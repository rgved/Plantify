package com.example.plantify_mad_final.api;

import android.graphics.Bitmap;
import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.common.util.concurrent.ListenableFuture;

public class GeminiClient {
    private final GenerativeModelFutures model;

    public GeminiClient(String apiKey) {
        GenerativeModel gm = new GenerativeModel("gemini-1.5-flash", apiKey);
        this.model = GenerativeModelFutures.from(gm);
    }

    public ListenableFuture<GenerateContentResponse> identifyPlant(Bitmap bitmap) {
        Content content = new Content.Builder()
            .addText("Identify this plant. Provide name, scientific name, description, and care tips in JSON.")
            .addImage(bitmap)
            .build();

        return model.generateContent(content);
    }
}
