package com.infoshareacademy.web;

import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/infoShareAcademy")
public class HomeworkServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(HomeworkServlet.class);

    private static final String TEMPLATE_NAME = "homework";

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> model = new HashMap<>();
        model.put("name", "Agnieszka");
        model.put("surname", "Negowska");
        model.put("teamName", "jjdd5-niewiem");
        model.put("date", LocalDateTime.now());

        Template template = templateProvider.getTemplate(
                getServletContext(), TEMPLATE_NAME
        );

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing template: ", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        PrintWriter out = resp.getWriter();

        List<String> parametersList = Collections.list(req.getParameterNames());
        for (String parameterName : parametersList) {
            String[] valuesAsArray = req.getParameterValues(parameterName);

            Arrays.stream(valuesAsArray)
                    .forEach(v -> out.println(v));
        }
    }
}



