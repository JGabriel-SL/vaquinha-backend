package com.donate.donate_app.service;

import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class FormDataForMap {

    // Método auxiliar para criar o form data a partir de um Map
    public String buildFormData(Map<String, String> data) {
        StringBuilder formData = new StringBuilder();
        data.forEach((key, value) -> {
            if (formData.length() > 0) {
                formData.append("&");
            }
            formData.append(URLEncoder.encode(key, StandardCharsets.UTF_8))
                    .append("=")
                    .append(URLEncoder.encode(value, StandardCharsets.UTF_8));
        });
        return formData.toString();
    }
}
