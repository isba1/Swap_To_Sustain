package com.SwapToSustain.Server.Service;

import com.SwapToSustain.Server.Converter.DTOConverter;
import com.SwapToSustain.Server.DTO.UserInterests;
import com.SwapToSustain.Server.Model.UserAccountInfoModel;
import com.SwapToSustain.Server.Repository.UserInfoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NewUserInterestsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private DTOConverter dtoConverter;


    public void saveUserInterests(String userID, UserInterests userInterests){

        UserAccountInfoModel userAccountInfoModel = userInfoRepository.findByUserID(UUID.fromString(userID));

        dtoConverter.convertDTO(userAccountInfoModel, userInterests);

        userInfoRepository.save(userAccountInfoModel);

    }

}
