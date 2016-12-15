package magicabc.com.cn.mabc.api;

import org.json.JSONObject;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * des:ApiService
 * Created by xsf
 * on 2016.06.15:47
 */
public interface ApiService {
    @GET("book/search")
    Observable<String> login(@Query("q") String name, @Query("tag") String tag, @Query("start") int start, @Query("count") int count);
    @GET("queryLesson")
    Observable<String> query(@Query("classId") int classId);
   // @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @GET("queryTeacher")
    Observable<String> getTeaacher(@Query("data") JSONObject jsonObject);

}
