package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.ResourceController;
import com.bxup.bxup.model.Photo;
import com.bxup.bxup.model.Show;
import com.bxup.bxup.model.ShowPhotoRel;
import com.bxup.bxup.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService{
	
LoginDao dao = null;
	
	@Override
	public List<Show> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<Show> show = LoginDao.SelectAllShow();	
		log.info("selectAllShowSuccess");
			return show;
	}
	
	
	@Override
	public String insertShow(Show showForm){						
		String sucflg = LoginDao.AddT_show(showForm);						
		return sucflg;		
	};
	
	@Override
	public String insertPhoto(Photo photoForm){						
		String ucfflg = LoginDao.AddT_photo(photoForm);						
		return ucfflg;		
	};
	
	@Override
	public String insertPhotoshowrel(ShowPhotoRel showPhotoRelForm){						
		String relflg = LoginDao.AddT_showphotorel(showPhotoRelForm);						
		return relflg;		
	};
	
	@Override
	public List<ShowPhotoRel> findrelbyid(long id){						
		List<ShowPhotoRel> rel = LoginDao.FindT_showphotorel(id);						
		return rel;		
	};
	
	@Override
	public List<Photo> findphotonamebyid(long photo_id){						
		List<Photo> photo = LoginDao.FindT_photonamebyid(photo_id);						
		return photo;		
	};
	
	


}
