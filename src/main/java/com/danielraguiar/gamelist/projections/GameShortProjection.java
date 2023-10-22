package com.danielraguiar.gamelist.projections;

public interface GameShortProjection {
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
