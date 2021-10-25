
//register page js

$(document).ready(function () {
    console.log("loaded..........")

    $('#reg-form').on('submit', function (event) {
        event.preventDefault();          //Stop the form goto servlate

        let form = new FormData(this)      //Store  all data in form variable


        //hide and show loader icon
        $("#submit-btn").hide();
        $("#loader").show();

        //send data on Register servlate
        $.ajax({
            url: "RegisterServlet",
            type: "post",
            data: form,
            success: function (data, textStatus, jqXHR) {
                console.log(data)
                //loader icon show
                $("#submit-btn").show();
                $("#loader").hide();


                if (data.trim() == 'done')
                {
                    swal("Register successfull! we redirect to login page...")
                            .then((value) => {
                                window.location = "login.jsp";

                            });
                } else
                {
                    swal(data)
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR)
                swal("something went wrong try again...");

                //loader icon
                $("#submit-btn").show();
                $("#loader").hide();
            },

            processData: false,
            contentType: false

        });


    });
});


$(document).ready(function () {
    let editStatus = false;

    $('#edit-profile-btn').click(function () {

        if (editStatus == false)
        {
            $('#profile-detail').hide()
            $('#profile-edit').show()
            $(this).text("Back")
            editStatus=true;
        }
        else
        {
            $('#profile-detail').show()
            $('#profile-edit').hide()
            $(this).text("Edit")
            editStatus=false;
        }
    })
});




//Add post java script  
        //Ajax
$(document).ready(function(){
//    alert('hello..');

$('#add-post-form').on("submit",function(event){
    //this funtion gets called when form submited
    event.preventDefault();
    
    console.log("you clicked on submit");
    let form=new FormData(this);
    
    //now requesting to server send form data
    $.ajax({
        url:"AddPostServlet",
        type:"post",
        data:form,
            success: function (data, textStatus, jqXHR) {
                //succes...
                console.log(data);
                if(data.trim()=='Done')
                {
                    swal("Good job!", "Your post uploaded!", "success");
                    
                    //close model
                    $('#postModal').modal('toggle')
                }
                else
                {
                    swal("Error!", "Something went wrong! try again", "error");
                }
                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                //erro
                swal("Error!", "Something went wrong! try again", "error");
            },
            processData: false,
            contentType:false
    })
})


})





//Loading post using ajax

function getPost(catId)
{
   
       
    $.ajax({
        
        url:'load_post.jsp',
        data:{cid:catId},
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            $('#loader').hide();
            $('#post-container').html(data);
        }
    })
}

$(document).ready(function(){
    alert("helo")
    getPost(0);
})

    
//$(document).ready(function(){
//    
//    $('#cardid').hover(function(){
//        $(this).css("background","green");
//    });
//});
