<template>
    <v-dialog
      v-model="dialog"
      width="900px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
        style="text-align:left;"
          color="primary"
          text
          large
          v-bind="attrs"
          v-on="on"
        >
        <v-icon left medium>file_present</v-icon>
          Просмотреть<br/>документы
        </v-btn>
      </template>
      <v-card  class="pa-10">
        <v-card-title>
          <span class="headline">Описательная часть</span>
        </v-card-title>
        <v-card-text>
          <span v-html="desc"></span>
        </v-card-text>
        <v-card-title>
          <span class="headline">Описание положительного эффекта</span>
        </v-card-title>
        <v-card-text>
          <span v-html="adva"></span>
        </v-card-text>
        <v-card-title>
          <span class="headline">Описание экономического эффекта</span>
        </v-card-title>
        <v-card-text>
          <span v-html="econ"></span>
        </v-card-text>
         <v-card-title>
          <span class="headline">Новизна</span>
        </v-card-title>
        <v-card-text>
          <span v-html="newn"></span>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="error"
            outline
            @click="dialog = false"
          >
            Выйти
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>


<script>
export default {
    name: 'documentsReq',
    props: ['desc', 'adva', 'econ', 'newn', 'disa'],
    data: () => ({
      dialog: false,  
    }),
}
</script>