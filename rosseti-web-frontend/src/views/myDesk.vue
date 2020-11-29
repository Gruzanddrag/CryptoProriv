<template>
<v-app class="blue-grey lighten-5">
    <v-layout row>
        <v-flex md4>
            <v-app class="blue-grey lighten-5">
                <v-container>
                    <v-flex>
                        <v-card class="ma-5 text-center mt-8" elevation="10">
                            <v-avatar size="70" class="mt-n7" elevation="10" style="border-radius:50%;">
                                <v-img src="https://randomuser.me/api/portraits/men/21.jpg"></v-img>
                            </v-avatar>
                            <v-card-title class="layout justify-center">Олег Петров</v-card-title>
                            <v-card-subtitle class="layout justify-center">РОССЕТИ, Ставрополь</v-card-subtitle>
                                <v-list>    
                                    <v-list-item>
                                        <v-list-item-title class="blue--text text--darken-1">Email</v-list-item-title>
                                        <v-list-item-title class="blue--text text--darken-1">Должность</v-list-item-title>
                                        <v-list-item-title class="blue--text text--darken-1">Заявки</v-list-item-title>
                                    </v-list-item>
                                    <v-list-item class="mt-n5">
                                        <v-list-item-subtitle>petrov@gmail.com</v-list-item-subtitle>
                                        <v-list-item-subtitle>Электрик</v-list-item-subtitle>
                                        <v-list-item-subtitle>2</v-list-item-subtitle>
                                    </v-list-item>
                                </v-list>
                        </v-card>
                    </v-flex>
                    <v-flex>
                        <v-card class="ma-5 mt-6"  elevation="10">
                            <v-list-item two-line style="text-align:center;">                           
                                <v-list-item-content>
                                    <v-list-item-title>Активные заявки</v-list-item-title> 
                                </v-list-item-content>
                            </v-list-item>
                            <v-divider></v-divider>
                            <v-list-item three-line>
                                <v-list-item-content>
                                    <v-list-item-title><v-icon left medium>list_alt</v-icon>Заявка</v-list-item-title>
                                    <v-list-item-subtitle>
                                    На рассмотрении модератора
                                    </v-list-item-subtitle>
                                    <v-list-item-subtitle>
                                    Добавлено 28/10/2020 16:53
                                    </v-list-item-subtitle>
                                </v-list-item-content>
                            </v-list-item>
                            <v-divider inset></v-divider>
                            <v-list-item three-line>
                                <v-list-item-content>
                                    <v-list-item-title><v-icon left medium>list_alt</v-icon>Заявка</v-list-item-title>
                                    <v-list-item-subtitle>
                                    На рассмотрении модератора
                                    </v-list-item-subtitle>
                                    <v-list-item-subtitle>
                                    Добавлено 28/10/2020 16:56
                                    </v-list-item-subtitle>
                                </v-list-item-content>
                            </v-list-item>
                            
                        </v-card>
                    </v-flex>
                    <v-flex>
                        <v-card class="ma-5 mt-6"  elevation="10">
                            <v-list-item style="text-align:center;">                           
                                <v-list-item-content>
                                    <v-list-item-title>Ваш прогресс</v-list-item-title> 
                                     <v-list>    
                                         <v-list-item-subtitle>Заявок</v-list-item-subtitle>
                                         <v-divider ></v-divider>
                                    <v-list-item>
                                        <v-list-item-title class="green--text text--darken-2">Принято</v-list-item-title>
                                        <v-list-item-title class="red--text text--darken-2">Отклонено</v-list-item-title>
                                        <v-list-item-title class="blue--text text--darken-2">Ожидают</v-list-item-title>
                                    </v-list-item>
                                    <v-list-item class="mt-n5">
                                        <v-list-item-title>1</v-list-item-title>
                                        <v-list-item-title>1</v-list-item-title>
                                        <v-list-item-title>2</v-list-item-title>
                                    </v-list-item>
                                </v-list>
                                 <v-list>    
                                    <v-list-item-subtitle>Статус</v-list-item-subtitle>
                                    <v-divider style="margin-bottom:10px;"></v-divider>
                                    <v-list-item>
                                        <v-list-item-title class="pink--text text--darken-3">Рейтинг</v-list-item-title>
                                        <v-list-item-title class="purple--text text--darken-2">Экон. эффект</v-list-item-title>
                                        <v-list-item-title class="orange--text text--darken-2">Процент</v-list-item-title>
                                    </v-list-item>
                                    <v-list-item class="mt-n5">
                                        <v-list-item-subtitle><v-icon left medium>stars</v-icon>4.4</v-list-item-subtitle>
                                        <v-list-item-subtitle><v-icon left medium>monetization_on</v-icon>до 100 тыс. руб</v-list-item-subtitle>
                                        <v-list-item-subtitle><v-icon left medium>card_giftcard</v-icon>12%</v-list-item-subtitle>
                                    </v-list-item>
                                </v-list>
                                </v-list-item-content>
                            </v-list-item>
                        </v-card>
                    </v-flex>
                </v-container>
            </v-app>
        </v-flex>
        <v-flex md8>
            <v-app class="rounded ma-11" style="box-shadow: 0px 4px 20px #bdbdbd;max-height:90vh;">
                    <v-container>
                        <v-flex pa-5>
                            <h2 style="color:#0D1E29;margin-bottom:20px;">История заявок</h2> 
                            <v-card class="pa-10">   
                            <v-layout row wrap>
                                <v-flex xs12 md4>
                                <div class="caption grey--text my-1"><v-icon left medium>drive_file_rename_outline</v-icon>Область применения</div>
                                <div>Недоступно</div>
                                </v-flex>
                                <v-flex xs6 sm2 md2>
                                <div class="caption grey--text my-1"><v-icon left medium>date_range</v-icon>Дата</div>
                                <div>Недоступно</div>
                                </v-flex>
                                <v-flex xs6 sm4 md2>
                                <div class="caption grey--text my-1"><v-icon left medium>person</v-icon>Сотрудник</div>
                                <div>Недоступно</div>
                                </v-flex>
                                <v-flex xs6 sm4 md2>
                                <div class="caption grey--text my-1"><v-icon left medium>category</v-icon>Категория</div>
                                <div>Недоступно</div>
                                </v-flex>
                                <v-flex xs2 sm4 md2>
                                <div class="caption grey--text my-1"><v-icon left medium>timelapse</v-icon>Статус</div>
                                <div>
                                    <v-chip small class="
                                        white--text caption my-2 red darken-1">
                                        Недоступно
                                        </v-chip>
                                </div>
                                </v-flex>
                            </v-layout>  
                        </v-card>                   
                    </v-flex>
                    <v-divider></v-divider>
                </v-container>             
            </v-app>  
        </v-flex>
    </v-layout>
  </v-app>
</template>

<script>
export default {
    name: 'myDesk',
}
</script>