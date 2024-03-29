package com.example.user.memoryhelper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

public class gall extends Activity {


    final int REQ_CODE_SELECT_IMAGE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gall);



        Button picture = (Button) findViewById(R.id.Btn_Find);

        picture.setOnClickListener(new View.OnClickListener(){



            public void onClick(View v){  // 클릭하면 ACTION_PICK 연결로 기본 갤러리를 불러옵니다.



                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);

                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);

            }



        });

    }



    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {





        Toast.makeText(getBaseContext(), "resultCode : "+resultCode,Toast.LENGTH_SHORT).show();



        if(requestCode == REQ_CODE_SELECT_IMAGE)

        {

            if(resultCode== Activity.RESULT_OK)

            {

                try {

                    //Uri에서 이미지 이름을 얻어온다.

                    //String name_Str = getImageNameToUri(data.getData());




                    //이미지 데이터를 비트맵으로 받아온다.

                    Bitmap image_bitmap 	= MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());

                    ImageView image = (ImageView)findViewById(R.id.SelectedImage);




                    //배치해놓은 ImageView에 set

                    image.setImageBitmap(image_bitmap);





                    //Toast.makeText(getBaseContext(), "name_Str : "+name_Str , Toast.LENGTH_SHORT).show();






                } catch (FileNotFoundException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                } catch (IOException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                } catch (Exception e)

                {

                    e.printStackTrace();

                }

            }

        }

    }



    public String getImageNameToUri(Uri data)

    {

        String[] proj = { MediaStore.Images.Media.DATA };

        Cursor cursor = managedQuery(data, proj, null, null, null);

        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);




        cursor.moveToFirst();




        String imgPath = cursor.getString(column_index);

        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);




        return imgName;

    }



}
