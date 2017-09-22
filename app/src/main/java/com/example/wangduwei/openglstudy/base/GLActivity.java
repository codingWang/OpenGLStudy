package com.example.wangduwei.openglstudy.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


/**
 * @desc: 1.检查版本信息
 * 2.设置Render
 * 3.GLSurfaceView生命周期处理
 * @auther:duwei
 * @date:2017/9/22
 */

public class GLActivity extends Activity implements GLSurfaceView.Renderer {

    protected GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLSurfaceView = new GLSurfaceView(this);

        //检查是否支持opengl2.0
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        boolean isSupportES2 = configurationInfo.reqGlEsVersion >= 0x20000;
        if (isSupportES2) {
            mGLSurfaceView.setEGLContextClientVersion(2);
            mGLSurfaceView.setRenderer(this);
        } else {
            Toast.makeText(this, "not support es2", Toast.LENGTH_LONG).show();
            return;
        }

        setContentView(mGLSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {

    }

    /**
     * 默认情况下，opengl按显示设备的刷新频率渲染界面，也可以手动指定
     * {@code mGLSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY)}
     * {@code mGLSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY)}
     * GlSurfaceView在后台线程渲染，和主线程交互可以通过：
     * runOnMainThread && mGlSurfaceView.enqueueEvent(Runnable)
     *
     * @param gl10
     */
    @Override
    public void onDrawFrame(GL10 gl10) {

    }
}
