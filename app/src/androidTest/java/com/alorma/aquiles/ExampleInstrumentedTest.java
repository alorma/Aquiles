package com.alorma.aquiles;

import android.support.test.runner.AndroidJUnit4;

import com.alorma.aquiles.request.Path;
import com.alorma.aquiles.request.Request;
import com.alorma.aquiles.response.BodyResponse;
import com.alorma.aquiles.response.Response;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static com.alorma.aquiles.Stub.stub;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    WireMockRule server = new WireMockRule();

    @Test
    public void buildGet() {
        Path path = new Path.Builder().setPath("/users/{userId}").setExactPath(false).build();

        Request request = Request.get()
                .setPath(path)
                .withQuery("extend", "true")
                .withHeader("token", UUID.randomUUID().toString());

        Response response = new BodyResponse("users/user_id_response.json").setStatusCode(204);

        stub(server, request, response);
    }

    @Test
    public void buildPost() {
        Path path = new Path.Builder().setPath("/users/{userId}").build();

        Request request = Request.post()
                .setPath(path)
                .withQuery("extend", "true")
                .withHeader("token", UUID.randomUUID().toString());

        Response response = new BodyResponse("users/user_new.json").setStatusCode(404);

        stub(server, request, response);
    }

    @Test
    public void buildDelete() {
        Path path = new Path.Builder().setPath("/users/{userId}").setExactPath(false).build();

        Request request = Request.delete().setPath(path);

        stub(server, request, 200);
    }
}
