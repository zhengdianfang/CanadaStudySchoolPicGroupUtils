import java.io.File

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val universitys = Utils.parseUniversityListFromFile()
        Utils.groupSchoolPics(universitys)
//        Utils.expandOldPicDirs()
//        val picDir = File("/Users/dfgzheng/Downloads/school_pics")
//        println(picDir.listFiles().count())
    }
}
