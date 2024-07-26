package com.rhythmfinders.domain.member;

import com.rhythmfinders.domain.member.aggregate.*;
import com.rhythmfinders.domain.member.service.MemberService;
import com.rhythmfinders.domain.member.view.MemberView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Application {

    public static int currentMemId = -1; //현재 로그인한 멤버 num 저장

    private static final MemberView memberView = new MemberView();

    public static void main(String[] args) throws IOException {

        memberView.loginView();
    }








}
