package com.livido.diagram;

import com.dot.renderder.DotDiagramParser;
import com.dot.renderder.chart.FlowChart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

public class MindfusionPngRenderer implements ImageRenderer {

    private final DotDiagramParser parser = new DotDiagramParser();
    private com.dot.renderder.ImageRenderer imageRenderer = new com.dot.renderder.ImageRenderer();


    @Override
    public void render(File input, String directory) {
        File outputDirectory = new File(directory);
        Arrays.stream(Objects.requireNonNull(input.listFiles()))
                .filter(f -> f.getName().endsWith(".gv"))
                .forEach(x->render(x, outputDirectory));
    }

    private void render(File diagram, File outputDirectory) {
        try {
            FlowChart chart = parser.parse(diagram.toPath());
            Path imageFile = outputDirectory.toPath().resolve(diagram.getName().replace(".gv", ""));
            imageRenderer.render(chart, imageFile.toFile().getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
