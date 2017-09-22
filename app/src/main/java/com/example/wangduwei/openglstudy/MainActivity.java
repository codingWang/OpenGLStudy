package com.example.wangduwei.openglstudy;

import com.example.wangduwei.openglstudy.base.GLActivity;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glViewport;

public class MainActivity extends GLActivity {
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        super.onSurfaceCreated(gl10, eglConfig);
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
    }


    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        super.onSurfaceChanged(gl10, width, height);
        glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);
        glClear(GL_COLOR_BUFFER_BIT);//擦除之前所有颜色，用glClearColor设置整个界面
    }
}
