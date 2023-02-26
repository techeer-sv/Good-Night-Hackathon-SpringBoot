package com.example.demo.global.enumpkg;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@AllArgsConstructor
//@Getter
public enum Category {
    한식 {
        @Override
        public String toString() {
            return "한식";
        }
    },
    중식{
        @Override
        public String toString() {
            return "중식";
        }
    },
    일식{
        @Override
        public String toString() {
            return "일식";
        }
    }
    ;

//    public Category valueOf() {
//
//        return this;
//    }
}
