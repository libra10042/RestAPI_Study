package com.example.hateoasdocs.resthateoasMember;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.RepresentationModel;


// Hateoas 기능을 사용하려면 RepesentationModel 클래스를 상속받은 클래스를 구현해야 한다.
public class MemberModel extends RepresentationModel<MemberModel> {

    public MemberModel(Member member){
        this.member = member;
    }

    // @JsonUnwrapped 어노테이션을 사용하면 member 반환시 member depth 를 없애고 member 의 멤버변수를 바로 출력 받을 수 있다.
    @JsonUnwrapped
    private final Member member;


}
