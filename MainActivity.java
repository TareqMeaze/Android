package com.meaze.hashmao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    HashMap<String,String> hashMap;
    ArrayList< HashMap<String,String> > arrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creatTable();
        listView = findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


    }
///====================================================================
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.new_layout,viewGroup,false);

            TextView tvCat =myView.findViewById(R.id.tvCat);
            TextView tvTitle =myView.findViewById(R.id.tvTitle);
            TextView tvDes =myView.findViewById(R.id.tvDes);
            ImageView imageView= myView.findViewById(R.id.imageView);
            LinearLayout layItem =myView.findViewById(R.id.layItem);


            hashMap = arrayList.get(position);
            String itemCat =hashMap.get("cat");
            String itemTitle =hashMap.get("title");
            String itemDes =hashMap.get("description");
            String itemImage =hashMap.get("image_url");

            Picasso.get()
                    .load(itemImage)
                    .placeholder(R.drawable.profile)
                    .into(imageView);

            tvCat.setText(itemCat);
            tvTitle.setText(itemTitle);
            tvDes.setText(itemDes);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            tvCat.setBackgroundColor(color);

            layItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MainActivity2.TITLE =itemTitle;
                    MainActivity2.DESCRIPTION=itemDes;
                    Bitmap bitmap = ( (BitmapDrawable) imageView.getDrawable() ).getBitmap();
                    MainActivity2.MYBITMAP=bitmap;


                    startActivity(new Intent(MainActivity.this, MainActivity2.class));


                }
            });



            return myView;
        }
    }
    ///........................................................


///========================================================================================
    private void creatTable (){

        hashMap =new HashMap<>();
        hashMap.put("cat","POLITICS");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/07/1654607584-0235.jpg");
        hashMap.put("title","ঐক্যবদ্ধ দুর্বার আন্দোলন গড়ে তুলতে হবে: গয়েশ্বর");
        hashMap.put("description","ক্ষমতাসীন আওয়ামী লীগ সরকারের পতন ছাড়া দেশের মানুষের কোনো সমস্যার সমাধান হবে না বলে মন্তব্য করেছেন বিএনপির স্থায়ী কমিটির সদস্য গয়েশ্বর চন্দ্র রায়।\n" +
                "\n" +
                "মঙ্গলবার (৭ জুন) জাতীয় প্রেসক্লাবের সামনে জাতীয়তাবাদী শ্রমিক দলের উদ্যোগে ‘চট্টগ্রামের সীতাকুণ্ডের বিএম কনটেইনার ডিপোতে অগ্নিকাণ্ডে নিহত-আহত শ্রমিকসহ সকলের জন্য ক্ষতিপূরণ আদায় ও দায়ী ব্যক্তিদের বিচার দাবিতে’ অনুষ্ঠিত মানববন্ধনে তিনি এসব কথা বলেন।\n" +
                "\n" +
                "তিনি বলেন, দেশে সেতু হয়েছে। এই পদ্মাসেতু-ই দেশের একমাত্র সমস্যা নয়। \n" +
                "আরো বহু সমস্যা আছে। এই পদ্মাসেতু আমাদের জীবনের নিরাপত্তা দেয় না, গাড়ীর নিচে পড়ে মানুষ মরা বন্ধ করে না। রিজার্ভের সাড়ে ছয়’শ কোটি টাকা লুটপাটের বিচার হয়নি। ১০ লাখ কোটি টাকা বিদেশে পাচার হয়েছে- তা ফেরত আনা হয়নি, শেয়ার মার্কেট থেকে প্রায় ৯০ হাজার কোটি টাকা নাই-এর কোনো সমাধান হয়নি। এই সরকার ক্ষমতায় থাকলে- এসব সমস্যার সমাধান হবে না। যত কঠিন ও কঠোর হওয়া যায়, আমাদের হতে হবে। দেশের জনগণকে সাথে নিয়ে রাজপথে ঐক্যবদ্ধ দুর্বার আন্দোলন গড়ে তুলতে হবে\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","SPORTS");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/07/1654595076-25.jpg");
        hashMap.put("title","তামিম মিথ্যা বলেছে :পাপন");
        hashMap.put("description","টি-টোয়েন্টি ক্রিকেট থেকে আপাতত ছয় মাসের বিরতিতে আছেন বাংলাদেশের ওয়ানডে অধিনায়ক তামিম ইকবাল। এই বিরতির পর টি-টোয়েন্টিতে নিজের ভবিষ্যত নিয়ে বলতে গিয়ে তামিম অভিযোগ করেই বলেছিলেন, টি-টোয়েন্টি ক্রিকেটে নিজের ভবিষ্যৎ নিয়ে নাকি কথা বলারই সুযোগ পাচ্ছেন না তিনি। \n" +
                "তামিমের এ বক্তব্যকে মিথ্যা বলছেন বাংলাদেশ ক্রিকেট বোর্ডের সভাপতি নাজমুল হাসান পাপন। ক্রিকেটভিত্তিক জনপ্রিয় ওয়েবসাইট ক্রিকবাজে পাপন জানিয়েছেন, তামিমের সঙ্গে অন্তত চারবার টি-টোয়েন্টি নিয়ে আলোচনা হয়েছে তারা। \n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","TORTURE");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/07/1654603727-032.jpg");
        hashMap.put("title","যৌতুকের দাবিতে স্ত্রীকে হত্যা ,স্বামীর মৃত্যুদণ্ড");
        hashMap.put("description","শেরপুরে যৌতুকের দাবিতে নির্যাতনে স্ত্রীকে হত্যার চাঞ্চল্যকর মামলায় এমদাদুল হক লালু (৪৫) নামে এক ব্যক্তিকে মৃত্যুদণ্ড ও এক হাজার টাকা অর্থদণ্ড দেওয়া হয়েছে। ৭ জুন মঙ্গলবার দুপুরে নারী ও শিশু নির্যাতন দমন ট্রাইব্যুনালের বিচারক মো. আখতারুজ্জামান একমাত্র আসামির উপস্থিতিতে ওই রায় ঘোষণা করেন। এমদাদুল হক সদর উপজেলার চরমুচারিয়া ইউনিয়নের মুকসুদপুর এলাকার মৃত মকবুল হোসেনের ছেলে।\n" +
                "\n" +
                "রায়ের বিষয়টি নিশ্চিত করে নারী ও শিশু নির্যাতন দমন ট্রাইব্যুনালের পিপি এ্যাডভোকেট গোলাম কিবরিয়া বুলু জানান, গত ২০১০ সালে সদর উপজেলার কামারিয়া ইউনিয়নের ছয়ঘড়িপাড়া এলাকার আব্দুর রশিদের মেয়ে রোখসানা খাতুনের বিয়ে হয় চরমুচারিয়া ইউনিয়নের মুকসুদপুর এলাকার বেসরকারি চাকরিজীবী এমদাদুল হক লালুর সাথে।\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","BCS");
        hashMap.put("image_url","https://cdn.news24bd.tv/public/news_images/2022/06/06/1654517047-021.jpg");
        hashMap.put("title","৪৩তম বিসিএস: লিখিত পরীক্ষা শুরু ২৪ জুলাই");
        hashMap.put("description","৪৩তম বিসিএসের লিখিত পরীক্ষা শুরু হবে আগামী ২৪ জুলাই। সাধারণ, কারিগরি বা পেশাগত ক্যাডারের জন্য ধাপে ধাপে ৭ সেপ্টেম্বর পর্যন্ত চলবে এ পরীক্ষা। সোমবার সরকারি কর্মকমিশনের (পিএসসি) পরীক্ষা নিয়ন্ত্রক (ক্যাডার) আবদুল্লাহ আল মামুনের সই করা বিজ্ঞপ্তিতে এ তথ্য জানানো হয়। \n" +
                "বিজ্ঞপ্তিতে বলা হয়, ৪৩তম বিসিএসের লিখিত পরীক্ষা ২৪ জুলাই থেকে শুরু হতে যাচ্ছে\n" +
                "ওই দিন সকাল ১০টা থকে দুপুর ২টা পর্যন্ত ইংরেজি বিষয়ের পরীক্ষা নেয়া হবে। এতে সাধারণ ও কারিগরি/পেশাগত উভয় ক্যাডারের জন্য পরীক্ষা আয়োজন করা হবে। \n" +
                "পরবর্তী সময়ে ২৫ জুলাই বাংলাদেশ বিষয়াবলী, ২৬ জুলাই আন্তর্জাতিক বিষয়াবলী, ২৭ জুলাই গাণিতিক যুক্তি, ২৮ জুলাই সাধারণ বিজ্ঞান ও প্রযুক্তি ও ৩১ জুলাই বাংলা পরীক্ষা (কারিগরি পেশাগত ক্যাডারের জন্য) আয়োজন করা হবে। এরপর ৫ সেপ্টেম্বর থেকে কারিগরি/পেশাগত ক্যাডারের জন্য বিভিন্ন বিষয়ের পরীক্ষা শুরু হবে। ৬ ও ৭ সেপ্টেম্বর এসব ক্যাডারের বিভিন্ন বিষয়ের পরীক্ষা নেয়া হবে। \n");
        arrayList.add(hashMap);


    }
////================================================================================================


}