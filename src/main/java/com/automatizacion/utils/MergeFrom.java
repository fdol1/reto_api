package com.automatizacion.utils;

import com.automatizacion.utils.jsonTemplates.FreemarkerTemplate;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import static com.automatizacion.utils.Constants.ERROR_MERGE;

public class MergeFrom {
    private static final FreemarkerTemplate freemarkerTemplate = new FreemarkerTemplate();
    private final String templateFile;

    public MergeFrom(String templateFile) {
        this.templateFile = templateFile;
    }

    public static MergeFrom template(String template) {
        return new MergeFrom(template);
    }

    public String withFieldsFrom(Map<String, String> fieldValues) {
        Template template = freemarkerTemplate.getTemplate(templateFile);

        Writer writer = new StringWriter();

        try {
            template.process(fieldValues, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException(ERROR_MERGE, e);
        }

        return writer.toString();
    }
}