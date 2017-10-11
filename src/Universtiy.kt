data class Universtiy(
        var id: Long,
        var chineseName: String,
        var englishName: String
){
    constructor() : this(0, "", "")
}