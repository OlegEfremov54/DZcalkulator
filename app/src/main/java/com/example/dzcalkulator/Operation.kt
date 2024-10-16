package com.example.dzcalkulator

class Operation( val first:String, val second:String) {
    fun chekTame(a:String):Int {
        var sekcount: Int = 0
        var mincount: Int = 0
        var hCount: Int = 0
        var rez: String = ""
        var rezMinSt: String = ""
        var rezH: String = ""
        var rezInt: Int = 0
        var aChar = a.toList()
        aChar = aChar.reversed()
        for (i in aChar.indices) {
            if (aChar[i].toChar() == 's') {
                sekcount = i
            }
            if (aChar[i].toChar() == 'm') {
                mincount = i
            }
            if (aChar[i].toChar() == 'h') {
                hCount = i
            }
        }
        if (aChar.contains('m') && (aChar.contains('s'))) {
            if ((mincount - sekcount) != 0) {
                for (i in sekcount + 1..mincount - 1) {
                    rez = rez + aChar[i]
                }
            }
        }
        if ((aChar.contains('m')) || (aChar.contains('h')) && (!aChar.contains('s'))) {
            rez = "0"
        }
        if (!aChar.contains('m') && (aChar.contains('s')) && (aChar.contains('h'))) {
            for (i in sekcount + 1..hCount - 1) {
                rez = rez + aChar[i]
            }
        }
        if (!aChar.contains('m') && (!aChar.contains('s'))) {
            rez = "0"
            rezMinSt = "0"

        }
        if (!aChar.contains('m') && (!aChar.contains('h'))) {
            for (i in sekcount + 1..aChar.size - 1) {
                rez = rez + aChar[i]
            }
        }
        if (aChar.contains('m') && (aChar.contains('h'))) {
            if ((hCount - mincount) != 0) {
                for (i in mincount + 1..hCount - 1) {
                    rezMinSt = rezMinSt + aChar[i]
                }
            }
        }
        if (aChar.contains('m')&& (!aChar.contains('h'))) {
            for (i in mincount + 1..aChar.size - 1) {
                rezMinSt = rezMinSt + aChar[i]
            }
        }
        if (!aChar.contains('m')) {  rezMinSt = "0" }
        if (aChar.contains('h')) {
            if (aChar.contains('m') && (aChar.contains('h'))) {
                if ((hCount - mincount) != 0) {
                    for (i in hCount + 1..aChar.size - 1) {
                        rezH = rezH + aChar[i]
                    }
                }
            }
            if (!aChar.contains('m') && (aChar.contains('h'))&&(aChar.contains('s'))) {
                if ((hCount - sekcount) != 0) {
                    for (i in hCount + 1..aChar.size - 1) {
                        rezH = rezH + aChar[i]
                    }
                }
            }
            if (!aChar.contains('m') && (aChar.contains('h'))&&(!aChar.contains('s'))) {
                for (i in hCount + 1..aChar.size - 1) {
                    rezH = rezH + aChar[i]
                }
            }
        }
        if (!aChar.contains('h')){ rezH="0"}
        rezInt=rez.reversed().toInt()+(rezMinSt.reversed()).toInt()*60+(rezH.reversed().toInt()*60*60)
        return rezInt
    }
    fun intToTame(a:Int):String{
        var hTame:String=""
        var h:Int=0
        var min:Int=0
        var sec:Int=0
        if (a>60){
            if (a>3600){
                h=(a/3600).toInt()
                min=((a-h*3600)/60).toInt()
                sec=(a-h*3600-min*60)
                hTame=h.toString()+"h"+min.toString()+"m"+sec.toString()+"s"
            }
            else{
                sec=a%60
                min=((a-sec)/60).toInt()
                hTame="0h"+min.toString()+"m"+sec.toString()+"s"
            }
        }
        else{
            hTame="0h0m"+a+"s"
        }
        return hTame
    }

    fun sum():String = intToTame(chekTame(first)+chekTame(second))


   fun dif():String = intToTame(chekTame(first)-chekTame(second))

}
