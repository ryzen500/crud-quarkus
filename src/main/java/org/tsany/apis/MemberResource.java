package org.tsany.apis;


import org.tsany.Entity.Member;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.tsany.Entity.Member.*;

@Path("/resteasy/member")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource {

    @GET

    public List<Member>  view() {
        return listAll();
    }

    @GET
    @Path("{id}")
    public Member show(@PathParam("id")Integer id){
    return findById(id);
    }

    @POST
    @Transactional
    public Member insert(Member member){
     member.persist();
     return member;
    }
    @PUT
    @Path("{id}")
    @Transactional
    public Member update(@PathParam("id")long id,Member member) {
        Member memberOriginal= findById(id);
        memberOriginal.getEntityManager().merge(member);
        memberOriginal.persist();
        return memberOriginal;
    }
    @DELETE
    @Path("{id}")
    @Transactional
    public boolean delete(@PathParam("id")long id ) {
     return Member.deleteById(id);
    }
}