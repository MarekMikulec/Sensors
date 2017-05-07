package com.example.marek.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView mSenorText;
    TextView mAllSensors;

    TextView mSensorTemperatureView;
    TextView mSensorTemperatureDeviceView;
    TextView mSensorHumidityView;
    TextView mSensorLightView;
    TextView mSensorAirPressureView;
    TextView mSensorMagnetometerView;
    TextView mSensorOrientationView;
    TextView mSensorLinearAccelometerView;
    TextView mSensorGravitySensorView;

    SensorManager mSensorManager;
    Sensor mSensor;

    Sensor mSensorTemperature;
    Sensor mSensorTemperatureDevice;
    Sensor mSensorHumidity;
    Sensor mSensorLight;
    Sensor mSensorAirPressure;
    Sensor mSensorMagnetometer;
    Sensor mSensorOrientation;
    Sensor mSensorLinearAccelometer;
    Sensor mSensorGravitySensor;
    List deviceSensors;


    ImageView mArrow;
    float currentDegre = 0.f;

    boolean opened = false;

    TextView mAllSensorsText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAllSensorsText = (TextView) findViewById(R.id.AllSensors);
        mAllSensorsText.setText(" Sensors details\n from device");

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        mAllSensors = (TextView) findViewById(R.id.Sensors);

        mArrow = (ImageView) findViewById(R.id.arrow);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Sensors\n" + deviceSensors.toString(), Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null).show();*/
                if (!opened) {
                    mAllSensorsText.setText(" All device sensors");
                    mAllSensors.setText(deviceSensors.toString());
                    opened = true;
                } else {
                    mAllSensorsText.setText(" Sensors details\n from device");
                    mAllSensors.setText("");
                    opened = false;
                }
            }

        });


        //Humidity sensor
        mSensorHumidity = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        mSensorHumidityView = (TextView) findViewById(R.id.Humidity);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) == null) {
            mSensorHumidityView.setTextColor(Color.RED);
            mSensorHumidityView.setText("No humidity sensor");
        }

        //Air Pressure sensor
        mSensorAirPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mSensorAirPressureView = (TextView) findViewById(R.id.AirPressure);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) == null) {
            mSensorAirPressureView.setTextColor(Color.RED);
            mSensorAirPressureView.setText("No pressure sensor");
        }

        //Gravity sensor
        mSensorGravitySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mSensorGravitySensorView = (TextView) findViewById(R.id.Gravity);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) == null) {
            mSensorGravitySensorView.setTextColor(Color.RED);
            mSensorGravitySensorView.setText("No gravity sensor");
        }

        //Temperature sensor
        mSensorTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorTemperatureView = (TextView) findViewById(R.id.Temperature);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) == null) {
            mSensorTemperatureView.setTextColor(Color.RED);
            mSensorTemperatureView.setText("No temperature sensor");
        }

        //Device temperature sensor
        mSensorTemperatureDevice = mSensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);
        mSensorTemperatureDeviceView = (TextView) findViewById(R.id.DeviceTemperature);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE) == null) {
            mSensorTemperatureDeviceView.setTextColor(Color.RED);
            mSensorTemperatureDeviceView.setText("No device temperature sensor");
        }

        //Light sensor
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorLightView = (TextView) findViewById(R.id.Light);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) == null) {
            mSensorLightView.setTextColor(Color.RED);
            mSensorLightView.setText("No light sensor");
        }

        //Linear accelometer
        mSensorLinearAccelometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        mSensorLinearAccelometerView = (TextView) findViewById(R.id.LinearAccelometer);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) == null) {
            mSensorLinearAccelometerView.setTextColor(Color.RED);
            mSensorLinearAccelometerView.setText("No linear accelometer");
        }

        //Magnetometer
        mSensorMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorMagnetometerView = (TextView) findViewById(R.id.Magnetometer);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) == null) {
            mSensorMagnetometerView.setTextColor(Color.RED);
            mSensorMagnetometerView.setText("No pressure sensor");
        }

        //Orientation sensor
        mSensorOrientation = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mSensorOrientationView = (TextView) findViewById(R.id.Orientation);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION) == null) {
            mSensorOrientationView.setTextColor(Color.RED);
            mSensorOrientationView.setText("No orientation sensor");
        }

    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensorGravitySensor, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSensorAirPressure, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSensorHumidity, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSensorLight, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSensorLinearAccelometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSensorMagnetometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSensorOrientation, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSensorTemperature, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSensorTemperatureDevice, SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float temp;
        float[] temps;
        switch (event.sensor.getType()) {
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                temp = event.values[0];
                mSensorHumidityView.setText("     " + Math.round(temp) + "%");
                break;
            case Sensor.TYPE_PRESSURE:
                temp = event.values[0];
                mSensorAirPressureView.setText("     " + Math.round(temp) + "hPa");
                break;
            case Sensor.TYPE_GRAVITY:
                temps = new float[3];
                temps[0] = event.values[0];
                temps[1] = event.values[1];
                temps[2] = event.values[2];
                String text3 = "     " + "X: " + Math.round(temps[0]) + "m/s^2\n";
                text3 += "     " + "Y: " + Math.round(temps[1]) + "m/s^2\n";
                text3 += "     " + "Z: " + Math.round(temps[2]) + "m/s^2";
                mSensorGravitySensorView.setText(text3);
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                temp = event.values[0];
                mSensorTemperatureView.setText("     " + Math.round(temp) + "°C");
                break;
            case Sensor.TYPE_TEMPERATURE:
                temp = event.values[0];
                mSensorTemperatureDeviceView.setText("     " + Math.round(temp) + "°C");
                break;
            case Sensor.TYPE_LIGHT:
                temp = event.values[0];
                mSensorLightView.setText("     " + Math.round(temp) + "lx");
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                temps = new float[3];
                temps[0] = event.values[0];
                temps[1] = event.values[1];
                temps[2] = event.values[2];
                String text = "     " + "X: " + Math.round(temps[0]) + "m/s^2\n";
                text += "     " + "Y: " + Math.round(temps[1]) + "m/s^2\n";
                text += "     " + "Z: " + Math.round(temps[2]) + "m/s^2";
                mSensorLinearAccelometerView.setText(text);
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                temps = new float[3];
                temps[0] = event.values[0];
                temps[1] = event.values[1];
                temps[2] = event.values[2];
                String text2 = "     " + "X: " + Math.round(temps[0]) + "μT\n";
                text2 += "     " + "Y: " + Math.round(temps[1]) + "μT\n";
                text2 += "     " + "Z: " + Math.round(temps[2]) + "μT";
                mSensorMagnetometerView.setText(text2);
                break;
            case Sensor.TYPE_ORIENTATION:
                temp = event.values[0];
                RotateAnimation ra = new RotateAnimation(currentDegre, -temp, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                currentDegre = -temp;
                mSensorOrientationView.setText(Math.round(temp) + "°");
                ra.setFillAfter(true);
                mArrow.startAnimation(ra);
                break;
        }


        //mSenorText.setText(temp.toString());


    }


}
