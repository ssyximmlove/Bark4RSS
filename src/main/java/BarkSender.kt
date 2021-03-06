import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

fun bark(deviceID:String,title:String,body:String){
    val apiUrl = "https://bark.supaku.cn/push"
    val client = OkHttpClient()
    val jsonStr = """
        {"device_key": "$deviceID",
        "title": "$title",
        "body": "$body"}
    """
    val dataBody = jsonStr.toRequestBody()
    val request = Request.Builder()
        .url(apiUrl)
        .post(dataBody)
        .addHeader("Content-Type","application/json; charset=utf-8")
        .build()
    val response = client.newCall(request).execute()
    println(response)
}
