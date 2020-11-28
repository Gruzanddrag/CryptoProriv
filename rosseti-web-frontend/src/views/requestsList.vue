<template>
  <div class="dashboard">
    <h1 class="subheading grey--text">Активные предложения</h1>
        <v-container class="my-10">
            <v-layout row class="mb-3 pa-3">
                <v-tooltip top>
                    <template v-slot:activator="{ on, attrs }"> 
                        <v-btn 
                        small 
                        text 
                        color="light-blue darken-4" 
                        @click="sortBy('date')" 
                        v-bind="attrs" 
                        v-on="on"
                        >
                            <v-icon left small>date_range</v-icon>
                            <span class="caption text-lowercase">По дате</span>
                        </v-btn>
                    </template>
                    <span>Сортировать по дате</span>
                </v-tooltip>
                <v-tooltip top>
                    <template v-slot:activator="{ on, attrs }"> 
                        <v-btn 
                        small 
                        text 
                        color="light-blue darken-4" 
                        @click="sortBy('title')" 
                        v-bind="attrs" 
                        v-on="on"
                        >
                            <v-icon left small>folder</v-icon>
                            <span class="caption text-lowercase">По названию</span>
                        </v-btn>
                    </template>
                    <span>Сортировать по названию</span>
                </v-tooltip>
            </v-layout>
                <v-expansion-panels>
                    <v-expansion-panel
                        class="pa-6 my-2"
                        v-for="statement in statements"
                        :key="statement.id"
                    >
                    <v-expansion-panel-header>
                        <v-layout row wrap>
                            <v-flex xs12 md3>
                            <div class="caption grey--text my-1"><v-icon left medium>drive_file_rename_outline</v-icon>Область применения</div>
                            <div>{{ statement.category.name }}</div>
                            </v-flex>
                            <v-flex xs6 sm2 md1>
                            <div class="caption grey--text my-1"><v-icon left medium>date_range</v-icon>Дата</div>
                            <div>{{ statement.createdAt }}</div>
                            </v-flex>
                            <v-flex xs6 sm4 md2>
                            <div class="caption grey--text my-1"><v-icon left medium>person</v-icon>Сотрудник</div>
                            <div>{{ statement.author.fIO }}</div>
                            </v-flex>
                            <v-flex xs6 sm4 md3>
                            <div class="caption grey--text my-1"><v-icon left medium>category</v-icon>Категория</div>
                             <div>{{  statement.category.name }}</div>
                            </v-flex>
                            <v-flex xs2 sm4 md2>
                            <div class="caption grey--text my-1"><v-icon left medium>timelapse</v-icon>Статус</div>
                            <div>
                                <v-chip small class="green darken-1 white--text caption my-2">Проверяется</v-chip>
                            </div>
                            </v-flex>
                            <v-flex xs2 sm4 md1>
                                <div class="caption grey--text">
                                     <v-dialog
                                        v-model="dialog"
                                        width="400"
                                    >
                                        <template v-slot:activator="{ on }">
                                        <v-icon v-on="on" dense large>
                                            mdi-share-variant
                                        </v-icon>
                                        </template>
                                        <v-card>
                                        <v-card-title>
                                            <span class="title font-weight-bold">Share</span>
                                            <v-spacer></v-spacer>
                                            <v-btn
                                            class="mx-0"
                                            icon
                                            @click="dialog = false"
                                            >
                                            <v-icon>mdi-close-circle-outline</v-icon>
                                            </v-btn>
                                        </v-card-title>
                                        <v-list>
                                            <v-list-item>
                                            <v-list-item-action>
                                                <v-icon color="indigo">
                                                mdi-facebook
                                                </v-icon>
                                            </v-list-item-action>
                                            <v-card-title>Facebook</v-card-title>
                                            </v-list-item>
                                            <v-list-item>
                                            <v-list-item-action>
                                                <v-icon color="cyan">
                                                mdi-twitter
                                                </v-icon>
                                            </v-list-item-action>
                                            <v-card-title>Twitter</v-card-title>
                                            </v-list-item>
                                            <v-list-item>
                                            <v-list-item-action>
                                                <v-icon>mdi-email</v-icon>
                                            </v-list-item-action>
                                            <v-card-title>Email</v-card-title>
                                            </v-list-item>
                                        </v-list>
                                        <v-text-field
                                            ref="link"
                                            :label="copied ? 'Link copied' : 'Click to copy link'"
                                            class="pa-4"
                                            readonly
                                            value="https://g.co/kgs/nkrK43"
                                            @click="copy"
                                        ></v-text-field>
                                        </v-card>
                                    </v-dialog>
                                </div>
                            </v-flex>
                        </v-layout>
                    </v-expansion-panel-header>
                    <v-expansion-panel-content>
                        <v-divider class="my-5"></v-divider>
                            <v-layout row wrap>
                                <v-flex xs12 md10 style="margin-bottom: 20px;">
                                    <h2>{{ statement.category.name }}</h2>
                                </v-flex>
                                <v-flex xs12 md2>
                                    <div class="text-right">
                                        <v-btn
                                        color="accent"
                                        elevation="2"
                                        fab
                                        icon
                                        ><v-icon>mdi-thumb-up</v-icon></v-btn>
                                        <span style="margin: 2px 10px; color:grey;">Понравилось: <strong>{{ statement.upvotes }}</strong></span>
                                    </div>
                                </v-flex>
                                <v-flex xs4 md2>
                                    <div class="caption grey--text my-1"><v-icon left medium>date_range</v-icon>Дата</div>
                                    <div>{{ statement.createdAt }}</div>
                                </v-flex>
                                <v-flex xs4 md2>
                                    <div class="caption grey--text my-1"><v-icon left medium>person</v-icon>Сотрудник</div>
                                    <div>{{ statement.author.fIO }}</div>
                                </v-flex>
                                <v-flex xs4 md2>
                                    <div class="caption grey--text my-1"><v-icon left medium>timelapse</v-icon>Статус</div>
                                    <div>
                                        <v-chip small class="green darken-1 white--text caption my-2">Проверяется</v-chip>
                                    </div>
                                </v-flex>
                                <v-flex xs12 md8>
                                    <h3>Описание предложения</h3>
                                    <span v-html="statement.projectDescription"></span>
                                </v-flex>
                                <v-flex xs12 md5>
                                <v-container style="max-width: 550px;" align="left">
                                    <v-timeline
                                        dense
                                        clipped
                                    >
                                        <v-slide-x-transition
                                        group
                                        >
                                        <v-timeline-item
                                            v-for="event in timeline"
                                            :key="event.id"
                                            class="mb-4"
                                            color="pink"
                                            small
                                        >
                                            <v-row justify="space-between">
                                            <v-col
                                                cols="7"
                                                v-text="event.text"
                                            ></v-col>
                                            <v-col
                                                class="text-right"
                                                cols="5"
                                                v-text="event.time"
                                            ></v-col>
                                            </v-row>
                                        </v-timeline-item>
                                        </v-slide-x-transition>
                                
                                        <v-timeline-item
                                        class="mb-6"
                                        hide-dot
                                        >
                                        <span style="font-weight:900;">Прогресс обработки заявления</span>
                                        </v-timeline-item>
                                
                                        <v-timeline-item
                                        class="mb-4"
                                        color="grey"
                                        icon-color="grey lighten-2"
                                        small
                                        >
                                        <v-row justify="space-between">
                                            <v-col cols="7">
                                            Заявление подано.
                                            </v-col>
                                            <v-col
                                            class="text-right"
                                            cols="5"
                                            >
                                            15:26 по МСК
                                            </v-col>
                                        </v-row>
                                        </v-timeline-item>
                                
                                        <v-timeline-item
                                        class="mb-4"
                                        small
                                        color="grey"
                                        >
                                        <v-row justify="space-between">
                                            <v-col cols="7">
                                            <v-chip
                                                class="white--text ml-0"
                                                color="purple"
                                                label
                                                small
                                            >
                                                Этап 1
                                            </v-chip>
                                            Первичное рассмотрение заявления.
                                            </v-col>
                                            <v-col
                                            class="text-right"
                                            cols="5"
                                            >
                                            02:25 по МСК
                                            </v-col>
                                        </v-row>
                                        </v-timeline-item>
                                
                                        <v-timeline-item
                                        class="mb-4"
                                        color="grey"
                                        small
                                        >
                                        <v-row justify="space-between">
                                            <v-col cols="7">
                                                <v-chip
                                                class="white--text ml-0"
                                                color="warning"
                                                label
                                                small
                                            >
                                                Этап 2
                                            </v-chip>
                                            Централизованная регистрация заявления.
                                            </v-col>
                                            <v-col
                                            class="text-right"
                                            cols="5"
                                            >
                                            07:15 по МСК
                                            </v-col>
                                        </v-row>
                                        </v-timeline-item>                         
                                        <v-timeline-item
                                        class="mb-4"
                                        color="cyan"
                                        small
                                        >
                                        <v-row justify="space-between">
                                            <v-col cols="7">
                                                <v-chip
                                                class="white--text ml-0"
                                                color="cyan"
                                                label
                                                small
                                            >
                                                Этап 3
                                            </v-chip>
                                            Подготовка для рассмотрения первым ЗГД.
                                            </v-col>
                                            <v-col
                                            class="text-right"
                                            cols="5"
                                            >
                                            14:00 по МСК
                                            </v-col>
                                        </v-row>
                                        </v-timeline-item>                   
                                    </v-timeline>
                                    </v-container>
                                </v-flex>
                            </v-layout>
                    </v-expansion-panel-content>
                    </v-expansion-panel>
                </v-expansion-panels>
        </v-container>
  </div>
</template>

<script>
import axios from "axios"

export default {
    name: 'requestsList',
    data: () => ({
        copied: false,
        dialog: false,
        rating: 10,
        statements: []
    }),
    created() {
        this.reloadStatements()
    },
    methods: {
        reloadStatements() {
            return axios.get(this.$store.state.apiurl + "statements")
            .then(res => {
                this.statements = res.data
            })
        },
        copy () {
        const markup = this.$refs.link
        markup.focus()
        document.execCommand('selectAll', false, null)
        this.copied = document.execCommand('copy')
      },
    },
}
</script>

<style scoped>
    .dashboard {
        margin: 50px;
    }    
</style>
