package com.SwapToSustain.Server.Repository;

import com.SwapToSustain.Server.Model.UserPostModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserPostRepository extends MongoRepository<UserPostModel, UUID> {

    List<UserPostModel> findAllByUserID(UUID userID);

    List<UserPostModel> findAllByUserName(String userName);

    UserPostModel findByPostID(UUID postID);

    void deleteByPostID(UUID postID);

//    @Query("{'$or':[ {'postStyle': {'$in': ?0}}, {'postBrand': {'$in': ?1}} ]}")
//    List<UserPostModel> findByPostStyleOrPostBrandOrPostSizeIn(List<String> styles, List<String> brands);

    @Query("{'$and': [ {'$or':[ {'postStyle': {'$in': ?0}}, {'postBrand': {'$in': ?1}} ]}, {'userID': {'$ne': ?2}} ]}")
    List<UserPostModel> findByPostStyleOrPostBrandOrPostSizeAndNotUserIdIn(List<String> styles, List<String> brands, UUID userId);


    @Query("{'$and': [{'postSize': ?0}, {'userID': {'$ne': ?1}}]}")
    List<UserPostModel> findByPostSizeAndNotUserId(String size, UUID userId);




}
