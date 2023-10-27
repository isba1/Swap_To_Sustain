package com.SwapToSustain.Server.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UserPost {

    //private byte[][] imageBinary;
    private List<String> base64Images;

    private String name;

    private String postDescription;

    private String postCategory;

    private String postBrand;
}
