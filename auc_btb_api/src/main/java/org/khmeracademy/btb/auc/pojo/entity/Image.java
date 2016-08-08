/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khmeracademy.btb.auc.pojo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author KUYLIM
 */
public class Image {
    @JsonProperty("ORIGINAL_IMAGE")
    private String originalImage;
    @JsonProperty("THUMBNAIL_IMAGE")
    
    private String thumbnailImage;
	
    public String getOriginalImage() {
	return originalImage;
    }
    public void setOriginalImage(String originalImage) {
	this.originalImage = originalImage;
    }
    public String getThumbnailImage() {
	return thumbnailImage;
    }
    public void setThumbnailImage(String thumbnailImage) {
	this.thumbnailImage = thumbnailImage;
    }
}
