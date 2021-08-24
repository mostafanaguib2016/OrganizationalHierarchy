package com.mmnaguib.organizationalhierarchy.model

data class EmployeesResponse(
    val ArabicMessage: String = "",
    val AsyncActionType: String = "",
    val BaseUrl: String = "",
    val Code: Int = 0,
    val Data: List<Data> = listOf(),
    val GUId: Int = 0,
    val IsDeleted: Int = 0,
    val LastUpdateDate: String = "",
    val Message: String = "",
    val PageCount: Int = 0,
    val ServiceName: String = "",
    val Success: Boolean = true
)

data class Data(
    val AccountID: Int,
    val ActivationCode: String,
    val AsyncActionType: Int,
    val CountryID: Int,
    val DepartmentID: Int,
    val DepartmentName: String,
    val Email: String,
    val FireBaseToken: Any,
    val GroupId: Any,
    val IsActivated: Boolean,
    val IsAdmin: Boolean,
    val IsBusinessHead: Boolean,
    val IsDeleted: Boolean,
    val IsStaff: Boolean,
    val IsUnderCompany: Boolean,
    val JobDescription: Any,
    val JobTitle: String,
    val LastChatMessage: Any,
    val ManagerID: Int,
    val MemberCode: String,
    val Name: String,
    val PhoneNumber: String,
    val ProfileImage: Any,
    val UserStateID: Int,
    val UserStateMessage: Any
)