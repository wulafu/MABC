package magicabc.com.cn.mabc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import magicabc.com.cn.mabc.api.Api;
import magicabc.com.cn.mabc.api.ApiService;
import magicabc.com.cn.mabc.api.HostType;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_bu)
    TextView tvBu;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.tv_1)
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_bu, R.id.tv,R.id.tv_1})
    public void OnClick(View v) {


        switch (v.getId()) {
            case R.id.tv_bu:
                Log.d("wulafu", "OnClick: --------");
                ApiService aDefault = Api.getDefault(HostType.REALSETYPE);
                aDefault.query(103665).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("wulafu", "onNext: ---------------------" + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        //  Log.d("wulafu", "onNext: ---------------------"+s);
                    }
                });
                break;
            case R.id.tv:
                Log.d("wulafu", "OnClick: --------");
                ApiService aDefault1 = Api.getDefault(HostType.DEVELOPTYPE);
                aDefault1.login("小王子", "", 0, 10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("wulafu", "onNext: ---------------------" + s);
                    }
                });
                break;
            case R.id.tv_1:
                Log.d("wulafu", "OnClick: --------");
                ApiService aDefault2 = Api.getDefault(HostType.REALSETYPE);

                JSONObject jsonObject = new JSONObject();
                try {

                    jsonObject.put("pageIndex",0);
                    jsonObject.put("pageSize",10);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aDefault2.getTeaacher(jsonObject).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("wulafu", "onNext: ---------------------" + s);
                    }
                });
                break;

        }


    }

}
