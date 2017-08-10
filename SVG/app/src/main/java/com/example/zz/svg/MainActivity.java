package com.example.zz.svg;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /**
     * 矢量动画的简单使用 前提：API21以上版本
     * 1.导入矢量图vd_star（随便命名）
     * 2.创建 animated-vector
          <animated-vector xmlns:android="http://schemas.android.com/apk/res/android"
             android:drawable="@drawable/vd_star" >  要执行动画的矢量图
             <target
             android:name="star_group"               让name为star_group的属性执行动画star_rotate，
             android:animation="@animator/star_rotate" />
             <target
             android:name="star"                     让name为star的属性执行动画star_shap
             android:animation="@animator/star_shap" />
             </animated-vector>

            star_group和start为vd_star对应属性的名称
     3.(1)动画 star_rotate
           <set xmlns:android="http://schemas.android.com/apk/res/android"
             android:ordering="sequentially">
             <set
             android:ordering="together">
             <objectAnimator
             android:duration="300"
             android:propertyName="scaleX"
             android:valueFrom="0.0"
             android:valueTo="1.0"/>
             <objectAnimator
             android:duration="300"
             android:propertyName="scaleY"
             android:valueFrom="0.0"
             android:valueTo="1.0"/>
             </set>
             <objectAnimator
             android:duration="500"
             android:propertyName="rotation"
             android:valueFrom="0"
             android:valueTo="360"/>

     </set>
        (2)动画 star_shap
             <set xmlns:android="http://schemas.android.com/apk/res/android"
             android:shareInterpolator="true"
             android:interpolator="@android:anim/accelerate_interpolator"
             android:ordering="sequentially"
             >
             <objectAnimator
             android:duration="500"
             android:propertyName="pathData"
             android:valueFrom="@string/star_data"
             android:valueTo="@string/star_lollipop"
             android:valueType="pathType"/>
             <objectAnimator
             android:duration="500"
             android:propertyName="pathData"
             android:valueFrom="@string/star_lollipop"
             android:valueTo="@string/star_data"
             android:valueType="pathType"/>
             </set>

     4.(1)矢量图 vd_star
             <?xml version="1.0" encoding="utf-8"?>
             <vector xmlns:android="http://schemas.android.com/apk/res/android"
             android:viewportWidth="400"
             android:viewportHeight="400"
             android:width="300px"
             android:height="300px">

             <group android:name="star_group"
             android:pivotX="200"
             android:pivotY="200"
             android:scaleX="1.0"
             android:scaleY="1.0">

             <path
             android:name="star"
             android:fillColor="#FF00FF"
             android:pathData="M 200.30535,69.729172
             C 205.21044,69.729172 236.50709,141.52218 240.4754,144.40532
             C 244.4437,147.28846 322.39411,154.86809 323.90987,159.53312
             C 325.42562,164.19814 266.81761,216.14828 265.30186,220.81331
             C 263.7861,225.47833 280.66544,301.9558 276.69714,304.83894
             C 272.72883,307.72209 205.21044,268.03603 200.30534,268.03603
             C 195.40025,268.03603 127.88185,307.72208 123.91355,304.83894
             C 119.94524,301.9558 136.82459,225.47832 135.30883,220.8133
             C 133.79307,216.14828 75.185066,164.19813 76.700824,159.53311
             C 78.216581,154.86809 156.16699,147.28846 160.13529,144.40532
             C 164.1036,141.52218 195.40025,69.729172 200.30535,69.729172 z"/>
             </group>
             </vector>
     (2)矢量图  @string/star_lollipop
             <path
             android:fillColor="#FF00FF"
             android:pathData="M 223.42,133.484
             C 237.895,98.1973 280.378,100.58 295.49,133.484
             C 302.176,148.044 293.576,165.914 270.253,183.357
             C 264.16,187.914 268.606,245.136 268.606,248.852
             C 268.606,256.589 268.606,295.171 268.606,302.907
             C 268.606,322.848 268.606,329.725 268.606,339.649
             C 268.606,347.385 255.048,349.681 255.048,339.649
             C 255.048,331.913 255.361,310.637 255.048,302.907
             C 254.579,291.371 255.048,256.788 255.048,249.052
             C 255.048,238.561 254.706,187.75 248.302,183.489
             C 221.536,165.677 218.848,144.628 223.42,133.484 z" />

             @string/star_data
             <path
             android:name="star"
             android:fillColor="#FF00FF"
             android:pathData="M 200.30535,69.729172
             C 205.21044,69.729172 236.50709,141.52218 240.4754,144.40532
             C 244.4437,147.28846 322.39411,154.86809 323.90987,159.53312
             C 325.42562,164.19814 266.81761,216.14828 265.30186,220.81331
             C 263.7861,225.47833 280.66544,301.9558 276.69714,304.83894
             C 272.72883,307.72209 205.21044,268.03603 200.30534,268.03603
             C 195.40025,268.03603 127.88185,307.72208 123.91355,304.83894
             C 119.94524,301.9558 136.82459,225.47832 135.30883,220.8133
             C 133.79307,216.14828 75.185066,164.19813 76.700824,159.53311
             C 78.216581,154.86809 156.16699,147.28846 160.13529,144.40532
             C 164.1036,141.52218 195.40025,69.729172 200.30535,69.729172 z"/>

     5.布局文件
             <ImageView
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:onClick="anim1"
             android:src="@drawable/animate_vd_star" />

     6.主要代码
             public void anim1(View v){
             ImageView iv = (ImageView) v;
             Drawable drawable = iv.getDrawable();
             if(drawable instanceof Animatable){
             ((Animatable)drawable).start();
             }
             }


     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void anim1(View v){
        ImageView iv = (ImageView) v;
        Drawable drawable = iv.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }
    }
}
