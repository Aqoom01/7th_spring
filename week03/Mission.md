### 미션 수행 목록

1. 홈 화면
    - End Point
    
        GET /home/{memberId}
    
    - Request Body
    
        GET 요청의 경우 Request Body가 딱히 없음
    
2. 마이 페이지 리뷰 작성
    - End Point
        
        POST /review/{memberId}/{shopId}
        
    - Request Body
        
        ```json
        {
        	"reviewText" : "매우 맛있어요.",
        	"reviewPic" : [
        		{
        			"PictureURL" : "~~~"
        		},
        		{
        			"PictureURL" : "~~~"
        		}
        	]
        }
        ```
        
3. 미션 목록 조회(진행 중, 진행 완료)
    - End Point
        
        진행 중 : GET /missions/{memberId}/Incomplete
        
        진행 완료 : GET /missions/{memberId}/Complete
        
    - Request Body
        
        GET 요청의 경우 Request Body가 딱히 없음
        
4. 미션 성공 누르기
    - End Point
        
        PATCH /missions/{memberId}/Incomplete
        
    - Request Body
        
        ```json
        {
        	"shopId" : 1003
        }
        ```
        
5. 회원 가입하기
    - End Point
        
        POST /users/signup
        
    - Request Body
        
        ```json
        {
        	"name" : "김현호",
        	"gender" : "남",
        	"birth" : "2001-10-15",
        	"address" : "서울특별시 노원구 광운로 20",
        	"address_spec" : "새빛관 101호",
        	"preference" : [
        		{
        			"category" : 1
        		},
        		{
        			"category" : 2
        		},
        		{
        			"category" : 9
        		}
        	]
        }
        ```