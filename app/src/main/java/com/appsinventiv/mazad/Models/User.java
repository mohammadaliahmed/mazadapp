package com.appsinventiv.mazad.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Body;

public class User {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("email_verified_at")
    @Expose
    private String emailVerifiedAt;
    @SerializedName("current_team_id")
    @Expose
    private String currentTeamId;
    @SerializedName("profile_photo_path")
    @Expose
    private String profilePhotoPath;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("second_name")
    @Expose
    private String secondName;
    @SerializedName("third_name")
    @Expose
    private String thirdName;
    @SerializedName("sir_name")
    @Expose
    private String sirName;
    @SerializedName("phone_verified")
    @Expose
    private Boolean phoneVerified;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("individual_type")
    @Expose
    private String individualType;
    @SerializedName("institutional_type")
    @Expose
    private String institutionalType;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("identity_or_residence")
    @Expose
    private String identityOrResidence;
    @SerializedName("company_registry_number")
    @Expose
    private String companyRegistryNumber;
    @SerializedName("registry_date")
    @Expose
    private String registryDate;
    @SerializedName("registry_expiry_date")
    @Expose
    private String registryExpiryDate;
    @SerializedName("registry_issuing_area")
    @Expose
    private String registryIssuingArea;
    @SerializedName("registry_area")
    @Expose
    private String registryArea;
    @SerializedName("registry_pic_url")
    @Expose
    private String registryPicUrl;
    @SerializedName("identity_of_registry")
    @Expose
    private String identityOfRegistry;
    @SerializedName("residence_permit_pic_url")
    @Expose
    private String residencePermitPicUrl;
    @SerializedName("profile_photo_url")
    @Expose
    private String profilePhotoUrl;
    private String password;
    private String api_username,api_password;

    public String getApi_username() {
        return api_username;
    }

    public void setApi_username(String api_username) {
        this.api_username = api_username;
    }

    public String getApi_password() {
        return api_password;
    }

    public void setApi_password(String api_password) {
        this.api_password = api_password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistryPicUrl() {
        return registryPicUrl;
    }



    public void setRegistryPicUrl(String registryPicUrl) {
        this.registryPicUrl = registryPicUrl;
    }

    public String getIdentityOfRegistry() {
        return identityOfRegistry;
    }

    public void setIdentityOfRegistry(String identityOfRegistry) {
        this.identityOfRegistry = identityOfRegistry;
    }

    public String getResidencePermitPicUrl() {
        return residencePermitPicUrl;
    }

    public void setResidencePermitPicUrl(String residencePermitPicUrl) {
        this.residencePermitPicUrl = residencePermitPicUrl;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getCurrentTeamId() {
        return currentTeamId;
    }

    public void setCurrentTeamId(String currentTeamId) {
        this.currentTeamId = currentTeamId;
    }

    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public String getIdentityOrResidence() {
        return identityOrResidence;
    }

    public void setIdentityOrResidence(String identityOrResidence) {
        this.identityOrResidence = identityOrResidence;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getSirName() {
        return sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }

    public Boolean getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(Boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIndividualType() {
        return individualType;
    }

    public void setIndividualType(String individualType) {
        this.individualType = individualType;
    }

    public String getInstitutionalType() {
        return institutionalType;
    }

    public void setInstitutionalType(String institutionalType) {
        this.institutionalType = institutionalType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyRegistryNumber() {
        return companyRegistryNumber;
    }

    public void setCompanyRegistryNumber(String companyRegistryNumber) {
        this.companyRegistryNumber = companyRegistryNumber;
    }

    public String getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate;
    }

    public String getRegistryExpiryDate() {
        return registryExpiryDate;
    }

    public void setRegistryExpiryDate(String registryExpiryDate) {
        this.registryExpiryDate = registryExpiryDate;
    }

    public String getRegistryIssuingArea() {
        return registryIssuingArea;
    }

    public void setRegistryIssuingArea(String registryIssuingArea) {
        this.registryIssuingArea = registryIssuingArea;
    }

    public String getRegistryArea() {
        return registryArea;
    }

    public void setRegistryArea(String registryArea) {
        this.registryArea = registryArea;
    }
}
