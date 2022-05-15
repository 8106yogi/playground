class TestK {

    companion object {

        @JvmStatic
        fun main(arr: Array<String>) {
            println("hello K")

        }

        fun convertStringToArray(s: String): Array<Int> {
            val arr: Array<String> = s.split(':').toTypedArray()

            return arr.map { it.toInt() }.toTypedArray()
        }

        fun convArrToString(arr: Array<Int>): String {
            var stringBuilder: StringBuilder = StringBuilder();
            for (i in arr.indices) {
                if (i == arr.size - 1) {
                    stringBuilder.append(String.format("%03d", arr[i]))
                } else
                    stringBuilder.append(String.format("%03d", arr[i])).append(":")
            }
            return stringBuilder.toString()

        }



        /*
         * Complete the 'gradingStudents' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY grades as parameter.
         */



        fun timeConversion(s: String): String? {
            // Write your code here
           var arr: Array<Int>? = null
            if (s.contains("PM")) {
                arr = convertStringToArray(s.replace("PM", ""))
                var t = arr[0]
                if (t + 12 < 24) {
                    t += 12
                }
                arr[0] = t

            } else if (s.contains("AM")) {
                arr = convertStringToArray(s.replace("AM", ""))
                var t = arr[0]
                if (t > 11) {
                    t -= 12
                }
                arr[0]=t
            }
            return arr?.let { convArrToString(it) }


        }

    }
    val list =listOf('M','D','C','L','X','V','I')
    fun isOrderIsSimple(s:String){
        var arr=s.toCharArray()
        var aI=arrayOfNulls<Int>(arr.size)
        for(i in arr.indices){
            aI[i]= list.indexOf(arr[i])

        }


}}