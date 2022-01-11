package com.andreea.proiectjavafacultate.models;

public class Image {
    int id;
    int modelId;
    String image;

    public Image(int id) {
        this.id = id;
    }


    public Image(String base64Encoding) {
        this.image = base64Encoding;
    }

    public Image(int id, String base64Encoding) {
        this.id = id;
        this.image = base64Encoding;
    }


    public void assignImageToModel(int modelId)  {
        this.modelId = modelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
