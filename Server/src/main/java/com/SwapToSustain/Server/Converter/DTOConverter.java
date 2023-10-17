package com.SwapToSustain.Server.Converter;

import com.SwapToSustain.Server.DTO.UserAccountInfo;
import com.SwapToSustain.Server.DTO.UserInterests;
import com.SwapToSustain.Server.DTO.UserPost;
import com.SwapToSustain.Server.Model.UserAccountInfoModel;
import com.SwapToSustain.Server.Model.UserPostModel;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class DTOConverter {

    public void convertDTO(UserAccountInfoModel userAccountInfoModel, UserInterests userInterests){
        userAccountInfoModel.setInterestBrand(userInterests.getBrands());
        userAccountInfoModel.setInterestCategory(userInterests.getClothingCategory());
        userAccountInfoModel.setPantSize(userInterests.getPantSize());
        userAccountInfoModel.setShirtSize(userInterests.getShirtSize());
        userAccountInfoModel.setJacketSize(userInterests.getJacketSize());
        userAccountInfoModel.setShoeSize(userInterests.getShoeSize());
    }

    public void convertDTO(UserAccountInfoModel userAccountInfoModel, UserAccountInfo userAccountInfo) {
        userAccountInfoModel.setUsername(userAccountInfo.getUsername());
        userAccountInfoModel.setPassword(userAccountInfo.getPassword());
        userAccountInfoModel.setFirstName(userAccountInfo.getFirstName());
        userAccountInfoModel.setLastName(userAccountInfo.getLastName());
        userAccountInfoModel.setEmail(userAccountInfo.getEmail());
        userAccountInfoModel.setPhone(userAccountInfo.getPhone());
        userAccountInfoModel.setAddress(userAccountInfo.getAddress());
    }


    public void convertDTO(UserPostModel userPostModel, UserPost userPost) {
        String base64Image = Base64.getEncoder().encodeToString(userPost.getImageBinary());
        userPostModel.setBase64Image(base64Image);
        userPostModel.setPostDescription(userPost.getPostDescription());
        userPostModel.setPostCategories(userPost.getPostCategories());
    }

}