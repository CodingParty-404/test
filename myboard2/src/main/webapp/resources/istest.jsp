<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <article>
        <div class="block">
            <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
    
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem mollitia accusamus sequi ipsa, rerum nam laboriosam, ipsam aperiam deleniti beatae expedita id quisquam veritatis corporis, voluptates ducimus molestiae eum adipisci.
    
            </p>
        </div>
    </article>

    <table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>번호</th>
							<th>title</th>
							<th>writer</th>
							<th>regDate</th>
							<th>upDate</th>
						</tr>
					</thead>
					<tbody id="is">
                        
					</tbody>
				</table>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
    //Javascript
var count = 0;
//스크롤 바닥 감지
window.onscroll = function(e) {
    //추가되는 임시 콘텐츠
    //window height + window scrollY 값이 document height보다 클 경우,
    if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
    	//실행할 로직 (콘텐츠 추가)
        count++;
        
        var addContent = "<tr><td>빈제목</td><td>작성자</td><td>등록시간</td><td>수정시간</td></tr>";
        // var addContent = '<div class="block"><p>'+ count +'번째로 추가된 콘텐츠</p></div>';
        //article에 추가되는 콘텐츠를 append
        $('#is').append(addContent);
    }
};

</script>
</html>