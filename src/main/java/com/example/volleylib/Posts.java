package com.example.volleylib;

public class Posts {
    private String postLink;
    private String subreddit;
    private String title;
    private String url;
    private String nsfw;
    private String author;
    private String ups;

    public Posts(String postLink, String subreddit, String title, String url, String nsfw, String author, String ups) {
        this.postLink = postLink;
        this.subreddit = subreddit;
        this.title = title;
        this.url = url;
        this.nsfw = nsfw;
        this.author = author;
        this.ups = ups;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postLink='" + postLink + '\'' +
                ", subreddit='" + subreddit + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", nsfw='" + nsfw + '\'' +
                ", author='" + author + '\'' +
                ", ups='" + ups + '\'' +
                '}';
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNsfw() {
        return nsfw;
    }

    public void setNsfw(String nsfw) {
        this.nsfw = nsfw;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }
}

/*
  "postLink": "https://redd.it/j1xofr",
  "subreddit": "dankmemes",
  "title": "I'm talking to YOU, luke",
  "url": "https://i.redd.it/qigy812lr2q51.png",
  "nsfw": false,
  "spoiler": false,
  "author": "valleyness",
  "ups": 3943
 */