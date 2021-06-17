package com.example.demo;

public class Validation {
public boolean detectString(String ch)
{
return !ch.isEmpty();

}
public boolean detecturl(String ch)
{
return ch.contains("http");
}
}
