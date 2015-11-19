require(["jquery"],function(){
    $(document).ready(function(){

        $('#modalIntro').modal('show');
        $("#close-modal-intro").click(function(e){
            $("#jplayer_1").jPlayer("stop");
        });


        var myPlaylist = new jPlayerPlaylist({
            jPlayer: "#jplayer_N",
            cssSelectorAncestor: "#jp_container_N"
        }, [
            {
                title:"Rey De Poder",
                artist:"Kairy Marquez",
                mp3:"http://k007.kiwi6.com/hotlink/wnd8yl0fjp/01_Rey_De_Poder.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Mi Mundo (Feat. Kairy Marquez)",
                artist:"Alex El Negro De La Cruz",
                mp3:"http://k007.kiwi6.com/hotlink/snpmhncmnb/02_Mi_Mundo_feat._Kairy_Marquez_.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Esperando Tu Venida",
                artist:"Shemá",
                mp3:"http://k007.kiwi6.com/hotlink/mq7ygzcsjn/04_Esperando_tu_venida.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Todo El Día",
                artist:"Sandy Caldera",
                mp3:"http://k007.kiwi6.com/hotlink/ke2ybnnvsg/Todo_El_Dia_-_Sandy_Caldera.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Te Amaré",
                artist:"Joan Sánchez & Rio Poderoso",
                mp3:"http://k007.kiwi6.com/hotlink/sk3v8ysam1/te_amare.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Te Equivocas",
                artist:"Jon Carlo",
                mp3:"http://k003.kiwi6.com/hotlink/6yibrbci00/Te_Equivocas.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Aunque Vengan Las Pruebas",
                artist:"Mario Jr & Adoracion Por Siempre",
                mp3:"http://k007.kiwi6.com/hotlink/48i1lnwbl5/En_Vivo_Acustico_desde_Long_Beach_CA_Aunque_Vengan_Las_Pruebas_MarioJr.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Tu Eres La Luz",
                artist:"Grupo Emmanuel",
                mp3:"http://k007.kiwi6.com/hotlink/f1zbjpum52/TuEresLaLuz_EnVivo_.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Aquí Estoy (Feat. D'FE)",
                artist:"Celinés Díaz",
                mp3:"http://k007.kiwi6.com/hotlink/zhkxo1xsbl/07_Aqui_Estoy_feat._D_Fe_.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Todo Se Lo Debo A Él",
                artist:"Angelito Villalona",
                mp3:"http://k007.kiwi6.com/hotlink/gsf7xqk5st/02_Todo_Se_Lo_Devo_A_El.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Roca Eterna",
                artist:"Gerardo Anderson",
                mp3:"http://k007.kiwi6.com/hotlink/18da85tj71/02_Roca_Eterna.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"La Voz Del Señor",
                artist:"Raul Urbina",
                mp3:"http://k007.kiwi6.com/hotlink/edab7g0lce/02_LA_VOZ_DEL_SENOR.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Ninguem Mais",
                artist:"Rosa De Saron",
                mp3:"http://k007.kiwi6.com/hotlink/4ez4zz6gox/06_Ningue_m_Mais.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Anjos De Deus",
                artist:"P. Marcelo Rossi",
                mp3:"http://k007.kiwi6.com/hotlink/pmjiev33vf/04_Anjo_de_Deus.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Qu'as-tu à donner",
                artist:"Glorious",
                mp3:"http://k007.kiwi6.com/hotlink/eb0fb592fx/03_Qu_as-tu_a_donner_Live_Frat_2011_.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Dis Le Au Monde",
                artist:"Glorious",
                mp3:"http://k007.kiwi6.com/hotlink/cf9nmmfwah/DisLeAuMonde.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Your Grace Is Enough",
                artist:"Matt Maher",
                mp3:"http://k007.kiwi6.com/hotlink/14fk47w0vb/01_Your_Grace_Is_Enough.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Restless",
                artist:"Audrey Assad",
                mp3:"http://k007.kiwi6.com/hotlink/j7qosw6yix/05_Restless.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Allí Quiero Estar",
                artist:"Barak",
                mp3:"http://k007.kiwi6.com/hotlink/u80hvei39y/11_Alli_Quiero_Estar.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Alabemos",
                artist:"Marcos Witt & T-Bone",
                mp3:"http://k007.kiwi6.com/hotlink/c1pgkqg9qh/Alabemos.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"El Cielo Y La Tierra",
                artist:"Julio Melgar",
                mp3:"http://k007.kiwi6.com/hotlink/zh09hk8q9z/el_cielo_y_la_tierra.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Jesus",
                artist:"Jairo Torres",
                mp3:"http://k007.kiwi6.com/hotlink/b7u9llb5tr/jesus_jairotorres.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Tu Luz",
                artist:"Saul Mondragon",
                mp3:"http://k007.kiwi6.com/hotlink/itk86vc2o0/tu_luz.mp3",
                poster: "images/m0.jpg"
            },
            {
                title:"Tu Amistad Me Hace Bien",
                artist:"Alex Campos",
                mp3:"http://k007.kiwi6.com/hotlink/7oggiyhqd8/01_Tu_Amistad_Me_Hace_Bien_feat._Jesu_s_Adrian_Romer_Lilly_Goodman_Marcos_Witt_Thalles_Roberto_.mp3",
                poster: "images/m0.jpg"
            },

        ], {
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
});
