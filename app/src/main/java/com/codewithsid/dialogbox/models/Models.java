package com.codewithsid.dialogbox.models;

public class Models  {


    /*{
        "status": 1,
            "title": "Best of Spotify",
            "imageURL": "https://i.pinimg.com/originals/93/46/53/934653214719cf630e0f5cf9c746b364.png",
            "success_url": "https://www.spotify.com/in-en/home/"
    }*/

   private String title;
    private String imageURL;
    private String success_url;

    public Models(String title, String imageURL, String success_url) {
        this.title = title;
        this.imageURL = imageURL;
        this.success_url = success_url;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getSuccess_url() {
        return success_url;
    }
}
