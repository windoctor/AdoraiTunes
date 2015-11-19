define("jPlayer/demo",["jquery"],function($){

    var myPlaylist = new jPlayerPlaylist({
            jPlayer: "#jplayer_N",
            cssSelectorAncestor: "#jp_container_N"
        }, []
        , {
            playlistOptions: {
                enableRemoveControls: true,
                autoPlay: false
            },
            swfPath: "js/jPlayer",
            supplied: "webmv, ogv, m4v, oga, mp3",
            smoothPlayBar: true,
            keyEnabled: true,
            audioFullScreen: false
        });

    function init(data){


        for(i = 0; i < data.length; i++){
            myPlaylist.add({
                "title":data[i].nombre,
                "artist":data[i].cantante,
                "mp3":data[i].link,
                "poster": data[i].portada
            });
        }
        $(document).ready(function(){



            $('#modalIntro').modal('show');
            $("#close-modal-intro").click(function(e){
                $("#jplayer_1").jPlayer("stop");
            });

            $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer,  function(){
                $('.musicbar').removeClass('animate');
                $('.jp-play-me').removeClass('active');
                $('.jp-play-me').parent('li').removeClass('active');

            });

            $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer,  function(){
                $('.musicbar').addClass('animate');
            });

            $(document).on('click', '.jp-play-me', function(e){
                e && e.preventDefault();
                var $this = $(e.target);
                if (!$this.is('a')) $this = $this.closest('a');

                $('.jp-play-me').not($this).removeClass('active');
                $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');

                $this.toggleClass('active');
                $this.parent('li').toggleClass('active');
                if( !$this.hasClass('active') ){
                    myPlaylist.pause();
                }else{
                    var i = Math.floor(Math.random() * (1 + 7 - 1));
                    myPlaylist.play(5);
                }

            });

            $('.clickPlay').click(function(e) {
                e.preventDefault();

                // using $(this).data("id"); will return 101 or any other value

                myPlaylist.play($(this).data("id"));
                // your code here...
                // readMP3($(this).data("id"));

            });



            // video

            $("#jplayer_1").jPlayer({
                ready: function () {
                    $(this).jPlayer("setMedia", {
                        title: "† = ♥ #DisLeAuMonde",
                        m4v: "layout/js/jPlayer/glorious.mp4"
                    }).jPlayer("play");
                },
                preload: "auto",
                swfPath: "js",
                supplied: "m4v",
                size: {
                    width: "100%",
                    height: "auto",
                    cssClass: "jp-video-360p"
                },
                globalVolume: true,
                smoothPlayBar: false,
                keyEnabled: true,
            });
        });
    }

    return{
        init : init
    };

});
