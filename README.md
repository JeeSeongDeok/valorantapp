# 발로란트 나만의 상점 어플리케이션
<p align=center>
<img src = "https://user-images.githubusercontent.com/23256819/129694135-94d27215-7ead-4931-90ca-7876ad9e0972.png" width=150 height = 300>
<img src = "https://user-images.githubusercontent.com/23256819/129694140-919e4773-a11a-4405-93e2-7000e3f7d7d8.png" width=150 height = 300>
<img src = "https://user-images.githubusercontent.com/23256819/129694259-989334ee-4bc7-41b8-a89c-a58d6c6faa7d.png" width=150 height = 300>
<img src = "https://user-images.githubusercontent.com/23256819/129694265-6ad371e6-d086-4fce-ba01-85624643bbbc.png" width=150 height = 300>
<img src = "https://user-images.githubusercontent.com/23256819/129694269-ddee9e4f-e965-4834-ab56-ba155e8ba806.png" width=150 height = 300>
</p>
<p align=center>
<img src = "https://user-images.githubusercontent.com/23256819/129694621-8ca4e762-7d85-46f0-a514-057defb36ffe.png" width=150 height = 300>
<img src = "https://user-images.githubusercontent.com/23256819/129694626-37d5cb76-a7eb-4d6b-bfe5-96f7ef1927e1.png" width=150 height = 300>
<img src = "https://user-images.githubusercontent.com/23256819/129694635-ebfeb1f3-796b-4001-81df-997c5c2d37ec.png" width=150 height = 300>
<img src = "https://user-images.githubusercontent.com/23256819/129694653-3ddf55e5-d4c4-48a6-96bd-3162c72949d1.png" width=150 height = 300>
<img src = "https://user-images.githubusercontent.com/23256819/129694660-3fead4ea-ac54-42e6-a472-4b105939357d.png" width=150 height = 300>
</p>

## About
 이 어플리케이션은 발로란트 나만의 상점을 휴대폰으로 쉽게 볼 수 있도록 만들어진 안드로이드 앱입니다. RIOT에 로그인을 한 후 얻은 토큰으로 API를 통해
 데이터를 주고 받습니다.

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - 안드로이드 개발을 위한 베이스 언어
- [AndroidX](https://developer.android.com/jetpack/getting-started) - 안드로이드 개발을 위한 라이브러리 모음
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - MVVM 모델을 구성하기 위해 사용된 라이브러리 모음
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - 데이터가 변경될 시 뷰에게 알려준다.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - 생명주기에 영향을 받지 않고, 데이터를 계속 보존할 수 있다.
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - 각 XML 레이아웃 파일에 대한 바인딩 클래스를 생성하고 코드를 더 쉽게 작성할 수 있도록 만들어 준다.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite를 mapping 해준다.
- [Retrofit](https://square.github.io/retrofit/) - Android HTTP 클라이언트
- [GSON](https://github.com/google/gson) - Kotlin 최신 JSON 라이브러리, GSON을 통해 JSON을 컨버트한다.


# Package Structure
    
    com.example.valorant    # Root Package
    .
    ├── data                # 데이터 핸들링
    │   ├── local           # Room(SQLite) 로컬 폴더
    |   │   ├── dao         # Room의 Data Access Object    
    │   ├── api             # API 핸들러     
    |   │   ├── API         # Retrofit 핸들링을 위한 정보 모음
    │   └── repository      # API에서 들고온 데이터를 저장
    |
    ├── model               # 데이터 모델(Entity, 매치데이터 등)
    |
    ├── di                  # Database, RetrofitBuilder를 넣어둠            
    │   
    ├── ui                  # 엑티비티/뷰 레이어 
    │   ├── main            # 메인 화면
    │   │
    |   ├── home            # 홈 프래그먼트
    |   │   ├── adapter     # Adapter for RecyclerView
    |   │   └── viewmodel   # ViewHolder for RecyclerView  
    │   │ 
    │   ├── loading         # 로딩 커스텀 디아로그
    │   │ 
    |   ├── login           # 로그인 액티비티, 로그인 디아로그
    |   │   └── viewmodel   # 아이디에 대한 토큰 데이터 관리
    │   │
    |   ├── stats           # 전적 프래그먼트
    |   │   ├── adapter     # 리사이클뷰 어뎁터
    |   │   ├── viewholder  # 리사이클뷰 뷰홀더 
    |   │   └── viewmodel   # 전적데이터 데이터 관리
    |   │    
    |   ├── store           # 상점 프래그먼트
    |   │   └── viewmodel   # 상점 데이터 관리
    |   │  
    │   └── setting         # 설정 화면
    |
    └── utils               # 다크모드 유틸 / SharePreference 등 다양한 유틸
    
    
## Architecture
이 어플리케이션은 MVVM모델을 사용했습니다. [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) 아키텍쳐.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)


## License
MIT 라이센스에 따라 배포합니다. 자세한 내용은 [라이센스](https://github.com/JeeSeongDeok/valorantapp/blob/master/LICENSE.md)를 참조해주세요
