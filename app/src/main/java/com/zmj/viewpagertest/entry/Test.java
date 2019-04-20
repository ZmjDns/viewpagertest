package com.zmj.viewpagertest.entry;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/4/17
 * Description :
 */
public class Test {

    String string = "{\n" +
            "\t\"result\": [{\n" +
            "\t\t\"id\": \"4036\",\n" +
            "\t\t\"question\": \"动画2中有几种违法行为？\",\n" +
            "\t\t\"answer\": \"2\",\n" +
            "\t\t\"item1\": \"一种违法行为\",\n" +
            "\t\t\"item2\": \"二种违法行为\",\n" +
            "\t\t\"item3\": \"三种违法行为\",\n" +
            "\t\t\"item4\": \"四种违法行为\",\n" +
            "\t\t\"explains\": \"有2种违法行为：1、打电话；2、堵车时占用公交车道通行！\",\n" +
            "\t\t\"url\": \"http://api.avatardata.cn/Jztk/Img?file=edc1ddd7f6d146c294f27a0b7909504a.swf\"\n" +
            "\t}, {\n" +
            "\t\t\"id\": \"4151\",\n" +
            "\t\t\"question\": \"驾驶机动车在这种条件的弯道处怎样转弯最安全？\",\n" +
            "\t\t\"answer\": \"1\",\n" +
            "\t\t\"item1\": \"减速靠右侧行驶\",\n" +
            "\t\t\"item2\": \"骑轧路中心行驶\",\n" +
            "\t\t\"item3\": \"靠弯道外侧行驶\",\n" +
            "\t\t\"item4\": \"借对向车道行驶\",\n" +
            "\t\t\"explains\": \"在对向有来车时出现弯道时，应当减速靠右侧行驶，因此本题选A。\",\n" +
            "\t\t\"url\": \"http://api.avatardata.cn/Jztk/Img?file=778910a2886c4e228cbc209a6ad7b33d.jpg\"\n" +
            "\t}],\n" +
            "\t\"error_code\": 0,\n" +
            "\t\"reason\": \"Succes\"\n" +
            "}";


    private void analString(){
        try{
            JSONObject jsonObject = new JSONObject(string);

            //resultArray  获取result中的数组
            JSONArray resultArray = jsonObject.getJSONArray("result");

            for (int i = 0; i < resultArray.length();i++){
                //object是  result中的数组中的单个元素
                JSONObject object = resultArray.getJSONObject(i);
                String id = object.optString("id");
                String question = object.optString("question");
                String answer = object.optString("answer");
                //下面的自己补全
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
