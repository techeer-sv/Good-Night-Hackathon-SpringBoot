package com.example.demo.global.enumpkg;

public enum SearchType {
    title{
        @Override
        public String toString() {
            return "title";
        }
    },
    content{
        @Override
        public String toString() {
            return "content";
        }
    },
    all{
        @Override
        public String toString() {
            return "all";
        }
    }
}
