package com.github.pickaxeengineer.assetgen;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Set;

@SupportedAnnotationTypes("com.github.pickaxeengineer.assetgen.Block")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class BlockProcessor extends AbstractProcessor {

    // TODO Logging

    public static final String GENERATION_PATH = "src/generated/resources";

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Hello from BlockProcessor");
        for(TypeElement annotation : annotations){
            System.out.println("Annotation: "+annotation);
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
            annotatedElements.stream().filter(ae -> ae.getKind() == ElementKind.FIELD).forEach(ae -> {
                System.out.println("Creating for "+ae.toString());
                Block an = ae.getAnnotation(Block.class);
                if(an != null){
                    final String modId = an.modId();
                    final String name = an.registryName();
                    // BlockState
                    write(an.blockType().blockStateType,modId,name);
                    // BlockModel
                    write(an.blockType().blockModelType, modId, name);
                    // Loot Table
                    write(an.lootType(), modId, name);
                    // Block Item Model
                    if(an.hasItem()){
                        write(ItemModelType.ITEM_BLOCK, modId, name);
                    }
                }
            });
        }
        System.out.println("done.");
        return true;
    }

    private void write(Generator gen, String modId, String name){
        String f = gen.fileName(modId, name);
        write(f, gen.generate(modId,name));
    }

    private void write(String file, String contents){
        try {
            FileObject fo = processingEnv.getFiler().createResource(StandardLocation.SOURCE_OUTPUT, "", file);
//            JavaFileObject fo = processingEnv.getFiler().createSourceFile(Paths.get(GENERATION_PATH, file).toString());
            System.out.println("Writing to: "+fo.getName());
            BufferedWriter bw = new BufferedWriter(fo.openWriter());
            bw.write(contents);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            // TODO fail
            e.printStackTrace();
        }
    }
}
