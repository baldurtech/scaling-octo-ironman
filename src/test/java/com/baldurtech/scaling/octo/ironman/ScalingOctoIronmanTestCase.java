package com.baldurtech.scaling.octo.ironman;

import com.baldurtech.unit.MiniatureSpiceTestCase;

public class ScalingOctoIronmanTestCase extends MiniatureSpiceTestCase
{
    Member createMemberWithUsername(String username) {
        Member member = new Member();
        member.setUsername(username);

        return member;
    }

    Member createMemberWithIdAndUsername(Long id, String username) {
        Member member = createMemberWithUsername(username);
        member.setId(id);
        return member;
    }
}
