package com.jikexueyuan.animateme;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 属性动画
 *      属性动画仅支持Android4.0以上系统使用
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCodeRotation).setOnClickListener(this);
        findViewById(R.id.btnAnimeteMe).setOnClickListener(this);
        findViewById(R.id.btnAnimeteMe2).setOnClickListener(this);
        findViewById(R.id.btnAnimeteSet).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCodeRotation:
                /**
                 * 使用代码实现旋转动画
                 *
                 * v 当前按钮对象
                 * rotation ： 内置动画效果
                 * 0 起始位置
                 * 90 停止位置
                 * 90 开始位置
                 * 360 结束位置
                 */
                //v.animate().rotation(360).setDuration(1000).start();
                ObjectAnimator.ofFloat(v, "rotation", 0, 90, 90, 360).setDuration(1000).start();
                break;
            case R.id.btnAnimeteMe:
                /**
                 * 使用xml实现旋转动画
                 * this 上下文
                 * R.animator.animete_me 动画文件
                 * res/animator/animete_me.xml
                 */

                ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,
                        R.animator.animete_me);
                animator.setTarget(v);
                animator.start();
                break;
            case R.id.btnAnimeteMe2:
                /**
                 * 使用xml实现动画集合
                 *
                 * 同时执行0-1透明度，0-200位置移动
                 * res/animator/animete_me_set.xml
                 */
                AnimatorSet mAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                        R.animator.animate_me_set);
                mAnimatorSet.setTarget(v);
                mAnimatorSet.start();
                break;
            case R.id.btnAnimeteSet:
                AnimatorSet set = new AnimatorSet();
                set.setDuration(1000);
                /**
                 * 使用代码实现动画集合
                 *
                 *  playSequentially() 一个接一个执行 ,set.playTogether() 同时执行
                 *  v,当前按钮对象
                 *  0 ，1 透明度从无到有
                 *  translationX  X轴移位
                 *  0，200 从自身位置移动200
                 */

                set.playSequentially(ObjectAnimator.ofFloat(v,"alpha",0,1),
                        ObjectAnimator.ofFloat(v,"translationX",0,200));
                set.start();


        }


    }
}
