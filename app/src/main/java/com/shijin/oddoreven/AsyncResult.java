package com.shijin.oddoreven;

import org.json.JSONObject;


interface AsyncResult
{
    void onResult(JSONObject object);
}