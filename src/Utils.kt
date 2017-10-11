import java.io.File

object Utils{

    fun parseUniversityListFromFile(): MutableList<Universtiy> {
        val file = File("/Users/dfgzheng/Downloads/SchoolData.txt")
        val universityList = mutableListOf<Universtiy>()
        file.readLines().forEachIndexed { index, line ->
            val university = Universtiy()
            university.id = index.toLong()
            line.split("###").forEachIndexed { index, s ->
                if (index == 0){
                    university.englishName = s
                }else if (index == 1){
                    university.chineseName = s
                }
            }
            universityList.add(university)
        }
        println(universityList.count())
        return universityList
    }

    fun groupSchoolPics(universtiys: MutableList<Universtiy>){
        val picDir = File("/Users/dfgzheng/Downloads/school_pics")
        println("pics count ${picDir.listFiles().count()}" )
        universtiys.forEach {university ->
            println("${university.englishName} ---- ${university.id}")
            var files = picDir.listFiles().filter { it.isFile }
            files.forEach {file ->
                if (file.name.startsWith(university.englishName)){
                    val groupDir = File("/Users/dfgzheng/Downloads/school_pics/${university.id}")
                    if (!groupDir.exists()){
                        groupDir.mkdir()
                    }
                    val targetFile = File(groupDir, file.name)
                    file.copyTo(targetFile)
                    file.deleteOnExit()
                }
            }
        }
    }

    fun expandOldPicDirs() {
        val oldPicDir = File("/Users/dfgzheng/Downloads/school_pics")
        oldPicDir.listFiles().filter { it.isDirectory }.forEach {
            it.listFiles().forEach {file ->
                var targetFile = File(oldPicDir, file.name)
                if (!targetFile.exists()){
                    file.copyTo(targetFile)
                }
            }
        }
    }

}