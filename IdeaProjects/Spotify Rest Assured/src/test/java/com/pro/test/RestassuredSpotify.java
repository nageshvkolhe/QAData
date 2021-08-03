package com.pro.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestassuredSpotify {
    public String token = "";
    public static String userId;

    @BeforeTest
    public void setUp(){
        token = "Bearer BQC2Jt3iAp59XdtwrHQcFj92g4lHd2rB7_T-7AUgosCL7ly32zWjrh4Qnt8zO_qK5oRsuLXu74wkXI7TaBDOWu5srQj3faiuKWJP-z3-nrRQiqecwMZgAHmgtLVBulseh3pkY_xIwymON31_vtxsn47SdHzNtatGbeY-PNPX-tS_p3Ed0LcG1yyELsHSl4kaulFJhI7MhEwt1dsrKDE6G7Hdbs7FaoHHd21tPRPs1Ib0jpr1UISJByRHsGnT0MPXlboLgvw8EVO6Pvgc1k5dqvYenXLJBMfGaAOerRiFWCxz";
    }

    @Test(priority = 0)
    public void User_Current_Profile(){
        Response response = given().contentType(ContentType.JSON)
                            .accept(ContentType.JSON)
                            .header("Authorization", token)
                            .when()
                            .get("https://api.spotify.com/v1/me");
        System.out.println("Response print using sout: " +response);
        userId = response.path("id");
        System.out.println("User Id :"+userId);
        response.prettyPrint();
    }

    @Test(priority = 1)
    public void Users_Profile(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/"+userId);
        response.prettyPrint();
    }

    @Test(priority = 2)
    public void List_of_Current_Users_Playlists(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("\thttps://api.spotify.com/v1/me/playlists");
        response.prettyPrint();
    }

    @Test(priority = 3)
    public void List_of_Users_Playlists(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("\thttps://api.spotify.com/v1/users/"+userId+"/playlists");
        response.prettyPrint();
    }

    @Test(priority = 4)
    public void Playlist(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/31DSgZVLJLuYYdmdL7HDmr");
        response.prettyPrint();
    }

    @Test(priority = 5)
    public void Playlist_items(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("\thttps://api.spotify.com/v1/playlists/31DSgZVLJLuYYdmdL7HDmr/tracks");
        response.prettyPrint();
    }

    @Test(priority = 6)
    public void Playlist_Cover_Image(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("\thttps://api.spotify.com/v1/me/31DSgZVLJLuYYdmdL7HDmr");
        response.prettyPrint();
    }

    @Test(priority = 7)  //remaining
    public void Add_Items_to_Playlist(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .body("")
                .post("https://api.spotify.com/v1/playlists/31DSgZVLJLuYYdmdL7HDmr/tracks");
        response.prettyPrint();
    }

    @Test(priority = 8)
    public void Create_Playlist(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
//                .body("{\n" +
//                        "   \"name\": \"nagesh moody\",\n" +
//                        "   \"description\": \"New playlist description\",\n" +
//                        "\"public\": false};}")
                .body("{\n" +
                        "  \"name\": \"Updated Playlist Name\",\n" +
                        "  \"description\": \"Updated playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/316pgn7hgnbehzs4mnxypxxaoz6e/playlists");
        response.prettyPrint();
    }

    @Test(priority = 9)
    public void custom_playlist_Cover_Image(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .put("https://api.spotify.com/v1/playlists/31DSgZVLJLuYYdmdL7HDmr/C:\\Users\\User\\Pictures\\capture_20201231002312.png");
        response.prettyPrint();
    }
}
